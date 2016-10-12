/**
  Mohammed Raza
  CSC 236 - Lab5 (class2)
*/


public class QueueOverflowException extends QueueException
{
	public QueueOverflowException()
	{
		super("Queue Overflow");
	}

	public QueueOverflowException(String msg)
	{
		super(msg);
	}
}