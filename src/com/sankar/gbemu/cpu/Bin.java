/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.cpu;

/**
 *
 * @author minerva
 */
public class Bin {
    
    public static byte add8(byte a, byte b, Flags f) {
        int va = (a & 0xff);
        int vb = (b & 0xff);
        int va_l = (a & 0x0f);
        int vb_l = (b & 0x0f);
        f.wh(((va_l + vb_l) & 0x10) != 0);
        int r = (va + vb);
        f.wc((r & 0x100) != 0);
        f.wz((r & 0xff) == 0);
        f.clrn();
        return (byte)(r & 0xff);
    }
    
    public static byte adc8(byte a, byte b, Flags f) {
        int c = (f.rc() ? 1 : 0);
        int va = (a & 0xff);
        int vb = (b & 0xff);
        int va_l = (a & 0x0f);
        int vb_l = (b & 0x0f);
        f.wh(((va_l + vb_l + c) & 0x10) != 0);
        int r = (va + vb + c);
        f.wc((r & 0x100) != 0);
        f.wz((r & 0xff) == 0);
        f.clrn();
        return (byte)(r & 0xff);
    }
    
    //Do not affect Z flag
    public static short add16woz(short a, short b, Flags f) {
        int va = (a & 0xffff);
        int vb = (b & 0xffff);
        int va_l = (a & 0xff);
        int vb_l = (b & 0xff);
        f.wh(((va_l + vb_l) & 0x100) != 0);
        int r = va + vb;
        f.wc((r & 0x10000) != 0);
        f.clrn();
        return (short)(r & 0xffff);
    }
    
    //Always clear Z flag
    public static short add8cz(short a, byte b, Flags f) {
        int va = (a & 0xffff);
        int vb = (((int)b) & 0xffff) ;
        int va_l = (va & 0xff);
        int vb_l = (vb & 0xff);
        f.wh(((va_l + vb_l) & 0x100) != 0);
        int r = va + vb;
        f.wc((r & 0x10000) != 0);
        f.clrz();
        f.clrn();
        return (short)r;
    }
    
    public static byte sub8(byte a, byte b, Flags f) {
        int va = (a & 0xff);
        int vb = (b & 0xff);
        int va_l = (a & 0x0f);
        int vb_l = (b & 0x0f);
        f.wh(va_l < vb_l);
        int r = (va - vb);
        f.wc(va < vb);
        f.wz(a == b);
        f.setn();
        return (byte)r;
    }
    
    public static byte sbc8(byte a, byte b, Flags f) {
        int c = (f.rc() ? 1 : 0);
        int va = (a & 0xff);
        int vb = ((b & 0xff) + c);
        int va_l = (a & 0x0f);
        int vb_l = ((b & 0x0f) + c);
        f.wh(va_l < vb_l);
        int r = va - vb;
        f.wc(va < vb);
        f.wz(a == b);
        f.setn();
        return (byte)r;
    }
    
    public static byte and8(byte a, byte b, Flags f) {
        byte r = (byte)(a & b);
        f.wz(r == 0);
        f.clrn();
        f.seth();
        f.clrc();
        return r;
    }
    
    public static byte or8(byte a, byte b, Flags f) {
        byte r = (byte)(a | b);
        f.wz(r == 0);
        f.clrn();
        f.clrh();
        f.clrc();
        return r;
    }
    
    public static byte xor8(byte a, byte b, Flags f) {
        byte r = (byte)(a ^ b);
        f.wz(r == 0);
        f.clrn();
        f.clrh();
        f.clrc();
        return r;
    }
    
    public static byte inc8(byte v, Flags f) {
        f.wh((v & 0x0f) == 0x0f);
        f.wz(v == 0xff);
        f.clrn();
        return (byte)(v + 1);
    }
    
    public static byte dec8(byte v, Flags f) {
        f.wh((v & 0x0f) == 0);
        f.wz(v == 1);
        f.setn();
        return (byte)(v - 1);
    }
    
    public static byte rl8(byte v, Flags f) {
        boolean c = (v & 0x80) != 0;
        byte r = (byte)((v & 0xff) << 1);
        if (f.rc())
            r = (byte)(r | 0x01);
        else
            r = (byte)(r & ~0x01);
        f.wc(c);
        f.wz(r == 0);
        f.clrn();
        f.clrh();
        return r;
    }
    
    public static byte rr8(byte v, Flags f) {
        boolean c = (v & 0x01) != 0;
        byte r = (byte)((v & 0xff) >> 1);
        if (f.rc())
            r = (byte)(r | 0x80);
        else
            r = (byte)(r & ~0x80);
        f.wc(c);
        f.wz(r == 0);
        f.clrn();
        f.clrh();
        return r;
    }
    
    public static byte rlc8(byte v, Flags f) {
        boolean c = (v & 0x80) != 0;
        byte r = (byte)((v & 0xff) << 1);
        if (c)
            r = (byte)(r | 0x01);
        else
            r = (byte)(r & ~0x01);
        f.wc(c);
        f.wz(r == 0);
        f.clrn();
        f.clrh();
        return r;
    }
    
    public static byte rrc8(byte v, Flags f) {
        boolean c = (v & 0x01) != 0;
        byte r = (byte)((v & 0xff) >> 1);
        if (c)
            r = (byte)(r | 0x80);
        else
            r = (byte)(r & ~0x80);
        f.wc(c);
        f.wz(r == 0);
        f.clrn();
        f.clrh();
        return r;
    }
    
    public static byte sla8(byte v, Flags f) {
        f.wc((v & 0x80) != 0);
        byte r = (byte)((v & 0xff) << 1);
        f.wz(r == 0);
        f.clrn();
        f.clrh();
        return r;
    }
    
    public static byte sra8(byte v, Flags f) {
        f.wc((v & 0x01) != 0);
        byte r = (byte)((v & 0xff) >> 1);
        f.wz(r == 0);
        f.clrn();
        f.clrh();
        return r;
    }
    
    public static byte srl8(byte v, Flags f) {
        f.wc((v & 0x01) != 0);
        byte r = (byte)((v & 0xff) >> 1);
        f.wz(r == 0);
        f.clrn();
        f.clrh();
        return r;
    }
    
    public static byte swap8(byte v, Flags f) {
        byte h = (byte)((v & 0xf0) >> 4);
        byte l = (byte)((v & 0x0f) << 4);
        f.wz(v == 0);
        f.clrn();
        f.clrh();
        f.clrc();
        return (byte)(l | h);
    }
    
    public static void bit8(byte v, int n, Flags f) {
        f.clrn();
        f.seth();
        f.wz((byte)((1 << n) & v) != 0);
    }
    
    public static byte set8(byte v, int n) {
        return (byte)((1 << n) | v);
    }
    
    public static byte res8(byte v, int n) {
        return (byte)(~(1 << n) & v);
    }
    
    public static short make16(byte a, byte b) {
        return (short)((a & 0xff) << 8 | (b & 0xff));
    }
    
    public static byte highByte(short val) {
        return (byte)((val >> 8) & 0xff);
    }
    
    public static byte lowByte(short val) {
        return (byte)(val & 0xff);
    }
    
    public static int toInt(byte b) {
        return b & 0x000000FF;
    }
    
    public static int toInt(short s) {
        return s & 0x0000FFFF;
    }
    
}
