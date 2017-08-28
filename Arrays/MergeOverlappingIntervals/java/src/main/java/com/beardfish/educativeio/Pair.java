
package com.beardfish.educativeio;
public class Pair<L,R> {
    public final L left;
    public final R right;

    public Pair(L left, R right)
    {
        this.left = left;
        this.right = right;
    }

    public L getLeft()
    {
        return this.left;
    }

    public R getRight()
    {
        return this.right;
    }

    @Override
    public String toString()
    {
        return "{" + left + "," + right + "}";
    }

    public static <L,R> Pair<L,R> makePair (L left, R right)
    {
        return new Pair<L,R> (left, right);
    }
}
