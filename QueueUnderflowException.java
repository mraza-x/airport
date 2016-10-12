/**
  Mohammed Raza
  CSC 236 - Lab5 (class3)
*/


public class QueueUnderflowException extends QueueException
{
	public QueueUnderflowException()
	{
		super("Queue Underflow");
	}

	public QueueUnderflowException(String msg)
	{
		super(msg);
	}
}