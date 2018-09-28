package stu.mango.algorithm.exam.queue.cat_dog_queue;

import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * @author mangococo
 * <p>
 * 2018/5/17 11:33
 **/
public class CatDogQueue {

    private Queue<PetNode> catQueue;

    private Queue<PetNode> dogQueue;

    private int count;

    public CatDogQueue() {
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

    public Pet poll() {
        if (isEmpty()) {
            throw new RuntimeException("No Pets!");
        }

        if(catQueue.isEmpty()) {
            return pollDog();
        }

        if (dogQueue.isEmpty()) {
            return pollCat();
        }

        assert catQueue.peek() != null;
        assert dogQueue.peek() != null;
        if (catQueue.peek().getIndex() < dogQueue.peek().getIndex()) {
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

    public long size() {
        return catQueue.size() + dogQueue.size();
    }

    public long catsSize() {
        return catQueue.size();
    }

    public long dogsSize() {
        return dogQueue.size();
    }

    public Pet peek() {
        if (isEmpty()) {
            throw new RuntimeException("No Pets!");
        }

        if(catQueue.isEmpty()) {
            return peekDog();
        }

        if (dogQueue.isEmpty()) {
            return peekCat();
        }

        assert catQueue.peek() != null;
        assert dogQueue.peek() != null;
        if (catQueue.peek().getIndex() < dogQueue.peek().getIndex()) {
            return peekCat();
        }

        return peekDog();
    }

    public Cat peekCat() {
        return (Cat) catQueue.peek().getPet();
    }

    public Dog peekDog() {
        return (Dog) dogQueue.peek().getPet();
    }

    private class Pet {
        private String type;

        Pet(String type) {
            this.type = type;
        }


        String getType() {
            return type;
        }

        @Override
        public String toString() {
            return type;
        }
    }

    private class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    private class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public class PetNode {
        private Pet pet;
        private int index;

        PetNode(Pet pet, int index) {
            this.pet = pet;
            this.index = index;
        }

        Pet getPet() {
            return pet;
        }

        int getIndex() {
            return index;
        }
    }
}
