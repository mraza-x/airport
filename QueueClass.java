/**
  Mohammed Raza
  CSC 236 - Lab5 (class5)
*/


public class QueueClass<T> implements QueueADT<T>
{
	private int maxQueueSize;
	private int count;
	private int queueFront;
	private int queueRear;
	private T[] list;

	public QueueClass()
	{
		maxQueueSize = 100;
		queueFront = 0;
		queueRear = maxQueueSize - 1;
		count = 0;
		list = (T[])new Object[maxQueueSize];
	}

	public QueueClass(int queueSize)
	{
		if(queueSize <= 0)
		{
			System.out.println("The size of the array to "
							+ "implement the queue must be positive.");
			System.err.println("Creating an array of the size 100.");

			maxQueueSize = 100;
		}
		else
			maxQueueSize = queueSize;

		queueFront = 0;
		queueRear = maxQueueSize - 1;
		count = 0;
		list = (T[])new Object[maxQueueSize];
	}

	// initialize Queue
	public void initializeQueue()
	{
		for(int i=queueFront; i<queueRear; i=(i+1)%maxQueueSize)
		list[i] = null;

		queueFront = 0;
		queueRear = maxQueueSize - 1;
		count = 0;
	}

	// Determine whether Queue is empty
	public boolean isEmptyQueue()
	{
		return (count == 0);
	}

	// Determine whether Queue is full
	public boolean isFullQueue()
	{
		return (count == maxQueueSize);
	}

	// Return first element of Queue
	public T front() throws QueueUnderflowException
	{
		if(isEmptyQueue())
			throw new QueueUnderflowException();

		return (T)list[queueFront];
	}

	// Return the last element of Queue
	public T back() throws QueueUnderflowException
	{
		if(isEmptyQueue())
			throw new QueueUnderflowException();

		return (T)list[queueRear];
	}

	// Add an element to Queue
	public void addQueue(T queueElement) throws QueueOverflowException
	{
		if(isFullQueue())
			throw new QueueOverflowException();

		queueRear = (queueRear + 1) % maxQueueSize;
		count++;
		list[queueRear] = queueElement;
	}

	// Remove the first element of Queue
	public void deleteQueue() throws QueueUnderflowException
	{
		if(isEmptyQueue())
			throw new QueueUnderflowException();

		count--;
		list[queueFront] = null;

		queueFront = (queueFront + 1) % maxQueueSize;
	}

	// Return the length of Queue
	public int length() throws QueueUnderflowException
	{
		return queueFront - queueRear;
	}


}


