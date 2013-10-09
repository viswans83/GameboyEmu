/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.mem;

/**
 *
 * @author minerva
 */
public interface ByteAccess {
    public byte r8(short addr);
    public void w8(short addr, byte value);
}
