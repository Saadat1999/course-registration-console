package genericTest;

public class ArrayList<A> extends List<A> {

    Object[] objects = new Object[0];

    @Override
    public void add(A objects) {
        Object[] newObjects = new Object[this.objects.length+1];
        System.arraycopy(this.objects, 0, newObjects, 0, this.objects.length);
        newObjects[this.objects.length] = objects;
        this.objects = newObjects;
    }

    @Override
    public A get(int index) {
        if(index<0 || index==this.objects.length) {
            throw new ArrayIndexOutOfBoundsException("Not found");
        }
        return (A) this.objects[index];
    }

    @Override
    public int size() {
        return this.objects.length;
    }

    @Override
    public void remove(int index) {
        if(index<0 || index==this.objects.length) {
            throw new ArrayIndexOutOfBoundsException("Not found");
        }
        Object[] newObjects = new Object[this.objects.length-1];
        System.arraycopy(this.objects, 0, newObjects, 0, index);
        System.arraycopy(this.objects, index+1, newObjects, index, this.objects.length-index-1 );
        this.objects=newObjects;
    }



}
