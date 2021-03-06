package lesson10Dz;

import java.util.ArrayList;
import java.util.List;

/*�������� ��������� Iterator, � ����� ��������� ����� hasNext(),
 next(). �������� ���� Collection,� ����� ��������� �� ���� ����� ����
 Object. �������� ����������� � ����������� ����������� ���� ��������
 ����� �����. �������� ��� ��������� �����, �� ������������������
 ��������� Iterator. ������������� ������ ��� ���:

 ������ ���� ������� �������� ������ �� ������� �� ����������. �������
 ����� �������� �������� �� ���� � ������� �� ����� ����� �����.

 ������ ���� ������� �� ���������� �� ������� �������� ����� ����
 �����. �������� ��������� ���� ���� ������� :

 �������� �� ���������� �� ������� �������� ������. ��������� �����
 ����� ������� ������ �� ���������� �� �� ��������, ���� ��� ��
 ������� ���� �������� �� �������.

 �������� ��������� ���� ���� �������:

 �������� �� ������� �� ���������� �������� ������, ��������� �����
 ����� ������� ������, ���� �� ������ �� ������ �� ����� ����� 100,
 � ������� �� �������

 �� �����.

 �������� ��������� ���� ���� �������:

 �������� �� ������� �� ���������� �������� ������. ��������� �����
 ������ ������� ����� �� ��������, ���� �� ������, ��� ������� �
 ����� �������� � ������� ���� �������� �� �������.

 �������� 50% +*/

public class Collection {

    private static Object[] objectArray;

    public Collection(int size) {
	objectArray = new Object[size];
    }

    public Object[] getObjectArray() {
	return objectArray;
    }

    // ������ ���� ������� �������� ������ �� ������� �� ����������
    public class FirstIterator implements Iterator {

	int cursor = 0; // index of next element to return

	@Override
	public boolean hasNext() {
	    return cursor != objectArray.length;
	}

	@Override
	public Object next() {
	    int i = cursor;
	    if (i >= objectArray.length)
		throw new IndexOutOfBoundsException();
	    cursor = i + 1;
	    if (i % 2 != 0)
		return 0;
	    return objectArray[i];
	}

    }

    // ������ ���� ������� �� ���������� �� ������� �������� ����� ���� �����.
    public class SecondIterator implements Iterator {

	int cursor = objectArray.length - 1; // index of next element to return

	@Override
	public boolean hasNext() {
	    return cursor != -1;
	}

	@Override
	public Object next() {
	    int i = cursor;
	    if (i < 0)
		throw new IndexOutOfBoundsException();
	    cursor = i - 2;
	    return objectArray[i];
	}

    }

    public List<Object> localIterator() {
	List<Object> list = new ArrayList<Object>();
	class LocalIterator implements Iterator {
	    int cursor = 0;

	    @Override
	    public boolean hasNext() {
		return cursor != objectArray.length;
	    }

	    @Override
	    public Object next() {
		int i = cursor;
		cursor = i + 5;
		if (i % 2 != 0)
		    return null;
		return objectArray[i];
	    }
	}
	LocalIterator iterator = new LocalIterator();
	while (iterator.hasNext()) {
	    Object o = iterator.next();
	    if (o == null)
		continue;
	    list.add((Integer) o - 100);
	    System.out.println((Integer) o - 100);
	}
	return list;
    }

    public static class StaticIterator implements Iterator {

	int cursor = 0;

	@Override
	public boolean hasNext() {
	    return cursor != objectArray.length;
	}

	@Override
	public Object next() {
	    int i = cursor;
	    cursor = i + 2;
	    Integer n = (Integer) objectArray[i];
	    if (n % 2 == 0)
		n = n + 1;
	    return (Object) n;
	}

    }

}
