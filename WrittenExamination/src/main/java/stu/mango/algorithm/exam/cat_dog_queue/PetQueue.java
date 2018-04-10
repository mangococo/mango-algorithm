package stu.mango.algorithm.exam.cat_dog_queue;

import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

/**
 *
 * @author mangococo
 *
 * 2018/4/10 21:16
 */
public class PetQueue {

    private Queue<PetNode> catQueue;

    private Queue<PetNode> dogQueue;

    private int count;

    public PetQueue() {
        this.catQueue = new LinkedTransferQueue<>();
        this.dogQueue = new LinkedTransferQueue<>();
    }

    public void add(Pet pet) {
        if ("cat".equals(pet.getType())) {
            catQueue.add(new PetNode(pet, count));
        } else if ("dog".equals(pet.getType())) {
            dogQueue.add(new PetNode(pet, count));
        }

        this.count++;
    }

    public Pet pollAll() {
        if (isEmpty()) {
            throw new RuntimeException("No Pets!");
        }

        if(catQueue.isEmpty()) {
            return pollDog();
        }

        if (dogQueue.isEmpty()) {
            return pollCat();
        }

        boolean catFirst = catQueue.peek().getIndex() > dogQueue.peek().getIndex();
        System.out.println(catFirst);
        if (catFirst) {
            return pollCat();
        }

        return pollDog();
    }

    public Cat pollCat() {
        if (catQueue.isEmpty())
            throw new RuntimeException("No Cat!");
        count--;
        return (Cat) catQueue.poll().getPet();
    }

    public Dog pollDog() {
        if (dogQueue.isEmpty())
            throw new RuntimeException("No Dog!");

        count--;
        return (Dog) dogQueue.poll().getPet();
    }

    public boolean isEmpty() {
        return isCatEmpty() && isDogEmpty();
    }

    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }
}

