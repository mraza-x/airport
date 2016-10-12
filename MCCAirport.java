/**
  Mohammed Raza
  CSC 236 - Lab5 (main)
*/

import java.util.*;
import java.text.*;

public class MCCAirport
{
	public static void main(String[] args)
	{

		double landingRate = 0;
		double takeoffRate = 0;

		double landingTime = 0;
		double takeoffTime = 0;

		double takeoffTimeTotal = 0;
		double landingTimeTotal = 0;

		DecimalFormat df = new DecimalFormat("#.######");

		QueueClass<Double> landingQueue = new QueueClass<Double>();
		QueueClass<Double> takeoffQueue = new QueueClass<Double>();
		QueueClass<Double> runwayQueue = new QueueClass<Double>();

		System.out.println("::: MCC Airport Program :::");

		Random iterate = new Random(System.currentTimeMillis());
		double it = iterate.nextDouble();
		final double ITERATE = it;


		for(int LCV = 0; LCV <= 1440; LCV++)
		{
			for(int i = 0; i <= ITERATE; i++)
			{
				Random rand1 = new Random();
				double random1 = rand1.nextDouble();
				 double RANDOM1 = random1;
				landingRate = RANDOM1;

				Random rand2 = new Random();
				double random2 = rand2.nextDouble();
				final double RANDOM2 = random2;
				takeoffRate = RANDOM2;
			}

				landingTime = (landingRate / 60.0);
				landingQueue.addQueue(landingRate);

				takeoffTime = (takeoffRate / 60.0);
				takeoffQueue.addQueue(takeoffRate);


			if(landingRate < landingTime)
				landingQueue.addQueue(landingRate);

			if(takeoffRate < takeoffTime)
				takeoffQueue.addQueue(takeoffRate);


			while(!runwayQueue.isEmptyQueue())
			{
				while(!landingQueue.isEmptyQueue())
				{
					runwayQueue.addQueue(landingRate);
				}

				runwayQueue.addQueue(takeoffRate);
			}


			System.out.println("Landing Queue elements: ");

			while(!landingQueue.isEmptyQueue())
			{
				System.out.println(df.format(landingQueue.front()) + " ");
				landingQueue.deleteQueue();
			}

			System.out.println();

			System.out.println("Take Off Queue elements: ");

			while(!takeoffQueue.isEmptyQueue())
			{
				System.out.println(df.format(takeoffQueue.front()) + " ");
				takeoffQueue.deleteQueue();
			}

			takeoffTimeTotal += takeoffTime;
			landingTimeTotal += landingTime;

			}

			System.out.println();

			double avgLandingTime = landingTimeTotal / 1440;
			double avgTakeoffTime = takeoffTimeTotal / 1440;

			System.out.println("Average Landing Queue Time: " + df.format(avgLandingTime));
			System.out.println("Average Take Off Queue Time: " + df.format(avgTakeoffTime));

			double avgLandingLength = landingQueue.length();
			double avgTakeoffLength = takeoffQueue.length();

			System.out.println("Average Landing Queue Length: " + df.format(avgLandingLength));
			System.out.println("Average Take Off Queue Length: " + df.format(avgTakeoffLength));

	}
}