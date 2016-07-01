package lesson12Dz;

/*�������� ����. �������� ���� MyThread ����������
 ���� �� ����� Thread. ������������� ����� run(), ��� ��� ����� ����
 ������� ������� � ������ ������� ����� Գ������. ��� �����
 ������������� � ����� run() ���� Scanner. ����� �� ������� � ������
 ������ �� ������ ������ ����� Գ������ � �� �� �������� � ��������� �
 1 �������.
 �������� ����. �������� ���� RunnableThread �������������� ���� ��
 ���������� Runnable. ����� run() ������������� ����� �����, ��� �����
 Գ������ ���������� � ����������� �������. ����� ������ ����� �����
 Scanner ������ �� ������ ������ ����� Գ������, ���� � ��������� � 1
 ������� ������� �� �� ���������� �� ������� ��������.
 ������ � ������ ������ ������� �������� � ���� ����� �����.
 ������ �� ������ :
 ���� Thread : 1 1 2 3 5 . . .
 ���� Runnable: . . .5 3 2 1 1
 ��������� ������� ������ � ExecutorService.

 �������� �� �������.*/

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class ExecutorTest {

    @Test
    public void executorTest() {
	Thread myThread = new MyThread(10);
	myThread.start();
	Runnable myRunnable = new RunnableThread(10);
	myRunnable.run();
    }

}