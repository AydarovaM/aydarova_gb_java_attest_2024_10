public class QueueItem implements Comparable<QueueItem>
{
    public String Id;
    public int Priority;

    public QueueItem(String id, int priority)
    {
        Id = id;
        Priority = priority;
    }

    @Override
    public int compareTo(QueueItem o) 
    {
        if(Priority < o.Priority)
            return -1;
        else if(Priority > o.Priority)
            return 1;
        return 0;
    }
}