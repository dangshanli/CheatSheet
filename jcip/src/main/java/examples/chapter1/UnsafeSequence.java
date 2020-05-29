package examples.chapter1;

import net.jcip.annotations.NotThreadSafe;

/**
 * Description:
 * Author: luzj
 * Date: 2019-06-01 13:34
 */
@NotThreadSafe
public class UnsafeSequence {
    private int value;

    /**
     * Returns a unique value.
     */
    public int getNext() {
        return value++;
    }
}
