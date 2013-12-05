package tm.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

//Question: is there an existing method that already does this?
public class CollectionToString 
{
	public Object target;	
	
	public CollectionToString(Object _target)
	{
		target = _target;
	}
	public boolean isCollection()
	{		
		if (target == null)
			return false;
		if (target instanceof Collection<?> || target instanceof Map || target.getClass().isArray())
			return true;
		return false;
	}
	public Object[] asArray()
	{
		if(isCollection())
		{
			if(target.getClass().isArray())			
				return (Object[])target;
			if(target instanceof Collection<?>)			
				return ((Collection<?>)target).toArray();			
			if(target instanceof Map)			
				return ((Map<?,?>)target).entrySet().toArray();
		}
		return null;	
	}
	public String asString()
	{
		if(isCollection())
		{
			String result = "";
			for(Object item : asArray())
				result += item + "\n";
			return result;
		}
		if(target != null)
			return target.toString();
		return null;
	}
}
