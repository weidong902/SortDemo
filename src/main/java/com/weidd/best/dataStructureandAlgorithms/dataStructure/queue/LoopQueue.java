package com.weidd.best.dataStructureandAlgorithms.dataStructure.queue;


/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-05-14 09:59
 * 循环队列: 解决自定义数组队列中取出元素时间复杂度高的问题.
 **/
public class LoopQueue<E> implements QueueDemo<E> {
    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity - 1];// 循环队列的容积,为了保证循环,空间会被有意识的浪费一个空间.
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity() {
        return data.length - 1;//data.length与元素能承载的元素个数之间有一个空间的差值.
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front)//判断循环队列是否是满的.
            resize(getCapacity() << 1);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        // 循环中需要注意.
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("队列为空,不能dequeue");
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        //缩容
        if (size == getCapacity() >> 2 && getCapacity() >> 1 != 0)
            resize(getCapacity() >> 1);
        return ret;
    }

    //队首元素
    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("队列为空");
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        sb.append("LoopQueue: front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail)//当前元素不是最后一个元素
                sb.append(", ");
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> arrayQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);

            if (i % 3 == 2) {
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }
    }
}
