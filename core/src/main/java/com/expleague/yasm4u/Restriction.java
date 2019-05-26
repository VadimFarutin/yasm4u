package com.expleague.yasm4u;

public interface Restriction {
    boolean satisfy(Restriction other);
}
