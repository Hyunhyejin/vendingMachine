package Util;

import java.util.ArrayList;
import java.util.List;

import Parents.ResultCallBack;

public class ResultEventHandler {
	
	private static ArrayList<ResultCallBack> eventList = new ArrayList<ResultCallBack>();
	
	public static void addEventListner(ResultCallBack resultCallBack) {
		if (eventList.indexOf(resultCallBack) == -1) {
			eventList.add(resultCallBack);	
		}
	}
	
	public static void callEvent(final Class<?> caller, String result, String msg)	{
		for (final ResultCallBack r : eventList) {
			if (r.getClass().getName().equals(caller.getName())) {
				
			}else {
				r.resultCallBack(result, msg);
			}
		}
	}
	
}
