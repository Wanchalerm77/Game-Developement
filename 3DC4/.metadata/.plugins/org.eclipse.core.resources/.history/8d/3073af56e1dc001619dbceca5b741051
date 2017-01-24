package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FinegrainedIntCell implements IntCell {
	private boolean empty = true;
	private int value = 0;

	private Lock lock;
	private Condition doWrite;
	private Condition doRead;

	public FinegrainedIntCell() {
		lock = new ReentrantLock();
		doWrite = lock.newCondition();
		doRead = lock.newCondition();
	}

	public void setValue(int valueArg) {
		lock.lock();
		while (!empty) {
			try {
				doWrite.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.value = valueArg;
		empty = false;
		doRead.signal();
		lock.unlock();
	}

	public int getValue() {
		lock.lock();
		while (empty) {
			try {
				doRead.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		doWrite.signal();
		int tmpval = value;
		empty = true;
		lock.unlock();
		return tmpval;
	}
}
