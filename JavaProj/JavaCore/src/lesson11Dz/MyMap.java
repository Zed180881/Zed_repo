package lesson11Dz;

/*������� ������: �������� ���� MyEntry<K,V>. ������� � �����
 ���������� �����, ������/������, toString. �������� ���� MyMap<K,V>,
 � ����� ���� ���� Set<MyEntry<K,V>>. ��������� � ������ ���� ������,
 �� �:
 �������� ����� �ᒺ�� � ����
 �������� �ᒺ�� ���� �� ������(����� ���� �� ����� �� ��������)
 �������� �ᒺ�� ���� �� ���������(�������� �ᒺ��� ������������
 ������� ������, ��� ����� ���������� ����)
 �������� �� ����� Set ������
 �������� �� ����� List �������
 �������� �� ����� ���� ����
 �������� 50%*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyMap<K, V> {

    private Set<MyEntry<K, V>> mapSet = new HashSet<>();

    public void add(MyEntry<K, V> entry) {
	mapSet.add(entry);
    }

    public void deleteByKey(K key) {
	mapSet.removeIf((e) -> e.getKey().equals(key));
    }

    public void deleteByValue(V value) {
	for (MyEntry<K, V> entry : mapSet) {
	    if (entry.getValue().equals(value))
		entry.setValue(null);
	}
    }

    public Set<K> getKeySet() {
	Set<K> keySet = new HashSet<>();
	for (MyEntry<K, V> entry : mapSet) {
	    System.out.println(entry.getKey());
	    keySet.add(entry.getKey());
	}
	return keySet;
    }

    public List<V> getValueList() {
	List<V> listValues = new ArrayList<V>();
	for (MyEntry<K, V> entry : mapSet) {
	    System.out.println(entry.getValue());
	    listValues.add(entry.getValue());
	}
	return listValues;
    }

    public void printMap() {
	for (MyEntry<K, V> entry : mapSet) {
	    System.out.println(entry);
	}
    }

    public Set<MyEntry<K, V>> getMapSet() {
        return mapSet;
    }  
    
}
