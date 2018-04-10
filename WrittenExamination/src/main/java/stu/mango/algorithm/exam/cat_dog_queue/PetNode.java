package stu.mango.algorithm.exam.cat_dog_queue;

/**
 *
 * @author mangococo
 *
 * 2018/4/10 21:17
 */
public class PetNode {
    private Pet pet;
    private int index;

    public PetNode(Pet pet, int index) {
        this.pet = pet;
        this.index = index;
    }

    public Pet getPet() {
        return pet;
    }

    public int getIndex() {
        return index;
    }
}

