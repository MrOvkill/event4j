
/*
 * Author : Samuel "MrOverkill" Meyers
 * Last Modified : 01/05/2015
 * License : Simplified BSD
 * 
 * Description:
 * 	The global manager for events.
 */

package event4j;

import java.util.ArrayList;

public class EventManager
{
    private static ArrayList<EventHandler> handlers;
    
    private static void ensureHandlers()
    {
        if(handlers == null)
        {
            handlers = new ArrayList<>();
        }
    }
    
    public static void addHandler(EventHandler evthnd)
    {
        ensureHandlers();
        
        if(evthnd != null)
        {
            handlers.add(evthnd);
        }
    }
    
    public static void raiseEvent(Event evt)
    {
        ensureHandlers();
        
        if(evt == null)
        {
            return;
        }
        
        for (EventHandler handler : handlers)
        {
            handler.onEvent(evt);
        }
    }
}