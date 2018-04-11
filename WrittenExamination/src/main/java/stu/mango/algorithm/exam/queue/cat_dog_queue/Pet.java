package stu.mango.algorithm.exam.queue.cat_dog_queue;

/**
 *
 * @author mangococo
 *
 * 2018/4/10 17:24
 */
public class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }


    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}

