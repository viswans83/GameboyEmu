/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.mem;

/**
 *
 * @author minerva
 */
public interface Memory extends ByteAccess {
    short r16(short addr);
    void  w16(short addr, short value);
}
