/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sankar.gbemu.cpu;

import com.sankar.gbemu.mem.Memory;

/**
 *
 * @author minerva
 */
public class InstructionSet {
    private final OpCode[] base_ops = new OpCode[Bin.toInt((byte)0xFF) + 1];
    private final OpCode[] prefix_ops = new OpCode[Bin.toInt((byte)0xFF) + 1];
    
    {
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (LD A,r)
        reg_op(new OpCode(0x78, 1, 4, "LD A,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(cpu.rb());
        }});
        
        //8-Bit (LD A,r)
        reg_op(new OpCode(0x79, 1, 4, "LD A,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(cpu.rc());
        }});
        
        //8-Bit (LD A,r)
        reg_op(new OpCode(0x7a, 1, 4, "LD A,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(cpu.rd());
        }});
        
        //8-Bit (LD A,r)
        reg_op(new OpCode(0x7b, 1, 4, "LD A,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(cpu.re());
        }});
        
        //8-Bit (LD A,r)
        reg_op(new OpCode(0x7c, 1, 4, "LD A,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(cpu.rh());
        }});
        
        //8-Bit (LD A,r)
        reg_op(new OpCode(0x7d, 1, 4, "LD A,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(cpu.rl());
        }});
        
        //8-Bit (LD A,r)
        reg_op(new OpCode(0x7f, 1, 4, "LD A,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(cpu.ra());
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (LD B,r)
        reg_op(new OpCode(0x40, 1, 4, "LD B,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(cpu.rb());
        }});
        
        //8-Bit (LD B,r)
        reg_op(new OpCode(0x41, 1, 4, "LD B,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(cpu.rc());
        }});
        
        //8-Bit (LD B,r)
        reg_op(new OpCode(0x42, 1, 4, "LD B,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(cpu.rd());
        }});
        
        //8-Bit (LD B,r)
        reg_op(new OpCode(0x43, 1, 4, "LD B,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(cpu.re());
        }});
        
        //8-Bit (LD B,r)
        reg_op(new OpCode(0x44, 1, 4, "LD B,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(cpu.rh());
        }});
        
        //8-Bit (LD B,r)
        reg_op(new OpCode(0x45, 1, 4, "LD B,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(cpu.rl());
        }});
        
        //8-Bit (LD B,r)
        reg_op(new OpCode(0x47, 1, 4, "LD B,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(cpu.ra());
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (LD C,r)
        reg_op(new OpCode(0x48, 1, 4, "LD C,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(cpu.rb());
        }});
        
        //8-Bit (LD C,r)
        reg_op(new OpCode(0x49, 1, 4, "LD C,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(cpu.rc());
        }});
        
        //8-Bit (LD C,r)
        reg_op(new OpCode(0x4a, 1, 4, "LD C,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(cpu.rd());
        }});
        
        //8-Bit (LD C,r)
        reg_op(new OpCode(0x4b, 1, 4, "LD C,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(cpu.re());
        }});
        
        //8-Bit (LD C,r)
        reg_op(new OpCode(0x4c, 1, 4, "LD C,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(cpu.rh());
        }});
        
        //8-Bit (LD C,r)
        reg_op(new OpCode(0x4d, 1, 4, "LD C,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(cpu.rl());
        }});
        
        //8-Bit (LD C,r)
        reg_op(new OpCode(0x4f, 1, 4, "LD C,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(cpu.ra());
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (LD D,r)
        reg_op(new OpCode(0x50, 1, 4, "LD D,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(cpu.rb());
        }});
        
        //8-Bit (LD D,r)
        reg_op(new OpCode(0x51, 1, 4, "LD D,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(cpu.rc());
        }});
        
        //8-Bit (LD D,r)
        reg_op(new OpCode(0x52, 1, 4, "LD D,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(cpu.rd());
        }});
        
        //8-Bit (LD D,r)
        reg_op(new OpCode(0x53, 1, 4, "LD D,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(cpu.re());
        }});
        
        //8-Bit (LD D,r)
        reg_op(new OpCode(0x54, 1, 4, "LD D,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(cpu.rh());
        }});
        
        //8-Bit (LD D,r)
        reg_op(new OpCode(0x55, 1, 4, "LD D,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(cpu.rl());
        }});
        
        //8-Bit (LD D,r)
        reg_op(new OpCode(0x57, 1, 4, "LD D,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(cpu.ra());
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (LD E,r)
        reg_op(new OpCode(0x58, 1, 4, "LD E,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(cpu.rb());
        }});
        
        //8-Bit (LD E,r)
        reg_op(new OpCode(0x59, 1, 4, "LD E,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(cpu.rc());
        }});
        
        //8-Bit (LD E,r)
        reg_op(new OpCode(0x5a, 1, 4, "LD E,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(cpu.rd());
        }});
        
        //8-Bit (LD E,r)
        reg_op(new OpCode(0x5b, 1, 4, "LD E,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(cpu.re());
        }});
        
        //8-Bit (LD E,r)
        reg_op(new OpCode(0x5c, 1, 4, "LD E,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(cpu.rh());
        }});
        
        //8-Bit (LD E,r)
        reg_op(new OpCode(0x5d, 1, 4, "LD E,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(cpu.rl());
        }});
        
        //8-Bit (LD E,r)
        reg_op(new OpCode(0x5f, 1, 4, "LD E,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(cpu.ra());
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (LD H,r)
        reg_op(new OpCode(0x60, 1, 4, "LD H,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(cpu.rb());
        }});
        
        //8-Bit (LD H,r)
        reg_op(new OpCode(0x61, 1, 4, "LD H,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(cpu.rc());
        }});
        
        //8-Bit (LD H,r)
        reg_op(new OpCode(0x62, 1, 4, "LD H,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(cpu.rd());
        }});
        
        //8-Bit (LD H,r)
        reg_op(new OpCode(0x63, 1, 4, "LD H,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(cpu.re());
        }});
        
        //8-Bit (LD H,r)
        reg_op(new OpCode(0x64, 1, 4, "LD H,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(cpu.rh());
        }});
        
        //8-Bit (LD H,r)
        reg_op(new OpCode(0x65, 1, 4, "LD H,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(cpu.rl());
        }});
        
        //8-Bit (LD H,r)
        reg_op(new OpCode(0x67, 1, 4, "LD H,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(cpu.ra());
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (LD L,r)
        reg_op(new OpCode(0x68, 1, 4, "LD L,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(cpu.rb());
        }});
        
        //8-Bit (LD L,r)
        reg_op(new OpCode(0x69, 1, 4, "LD L,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(cpu.rc());
        }});
        
        //8-Bit (LD L,r)
        reg_op(new OpCode(0x6a, 1, 4, "LD L,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(cpu.rd());
        }});
        
        //8-Bit (LD L,r)
        reg_op(new OpCode(0x6b, 1, 4, "LD L,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(cpu.re());
        }});
        
        //8-Bit (LD L,r)
        reg_op(new OpCode(0x6c, 1, 4, "LD L,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(cpu.rh());
        }});
        
        //8-Bit (LD L,r)
        reg_op(new OpCode(0x6d, 1, 4, "LD L,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(cpu.rl());
        }});
        
        //8-Bit (LD L,r)
        reg_op(new OpCode(0x6f, 1, 4, "LD L,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(cpu.ra());
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (LD B,nn)
        reg_op(new OpCode(0x06, 2, 8, "LD B,%02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            cpu.wb(arg);
        }});
        
        //8-Bit (LD C,nn)
        reg_op(new OpCode(0x0e, 2, 8, "LD C,%02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            cpu.wc(arg);
        }});
        
        //8-Bit (LD D,nn)
        reg_op(new OpCode(0x16, 2, 8, "LD D,%02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            cpu.wd(arg);
        }});
        
        //8-Bit (LD E,nn)
        reg_op(new OpCode(0x1e, 2, 8, "LD E,%02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            cpu.we(arg);
        }});
        
        //8-Bit (LD H,nn)
        reg_op(new OpCode(0x26, 2, 8, "LD H,%02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            cpu.wh(arg);
        }});
        
        //8-Bit (LD L,nn)
        reg_op(new OpCode(0x2e, 2, 8, "LD L,%02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            cpu.wl(arg);
        }});
        
        //8-Bit (LD A,nn)
        reg_op(new OpCode(0x3e, 2, 8, "LD A,%02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            cpu.wa(arg);
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (LD B,(HL))
        reg_op(new OpCode(0x46, 1, 8, "LD B,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(mem.r8(cpu.rhl()));
        }});
        
        //8-Bit (LD C,(HL))
        reg_op(new OpCode(0x4e, 1, 8, "LD C,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(mem.r8(cpu.rhl()));
        }});
        
        //8-Bit (LD D,(HL))
        reg_op(new OpCode(0x56, 1, 8, "LD D,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(mem.r8(cpu.rhl()));
        }});
        
        //8-Bit (LD E,(HL))
        reg_op(new OpCode(0x5e, 1, 8, "LD E,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(mem.r8(cpu.rhl()));
        }});
        
        //8-Bit (LD H,(HL))
        reg_op(new OpCode(0x66, 1, 8, "LD H,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(mem.r8(cpu.rhl()));
        }});
        
        //8-Bit (LD L,(HL))
        reg_op(new OpCode(0x6e, 1, 8, "LD L,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(mem.r8(cpu.rhl()));
        }});
        
        //8-Bit (LD A,(HL))
        reg_op(new OpCode(0x7e, 1, 8, "LD A,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(mem.r8(cpu.rhl()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (LD (HL),B)
        reg_op(new OpCode(0x70, 1, 8, "LD (HL),B") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), cpu.rb());
        }});
        
        //8-Bit (LD (HL),C)
        reg_op(new OpCode(0x71, 1, 8, "LD (HL),C") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), cpu.rc());
        }});
        
        //8-Bit (LD (HL),D)
        reg_op(new OpCode(0x72, 1, 8, "LD (HL),D") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), cpu.rd());
        }});
        
        //8-Bit (LD (HL),E)
        reg_op(new OpCode(0x73, 1, 8, "LD (HL),E") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), cpu.re());
        }});
        
        //8-Bit (LD (HL),H)
        reg_op(new OpCode(0x74, 1, 8, "LD (HL),H") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), cpu.rh());
        }});
        
        //8-Bit (LD (HL),L)
        reg_op(new OpCode(0x75, 1, 8, "LD (HL),L") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), cpu.rl());
        }});
        
        //8-Bit (LD (HL),A)
        reg_op(new OpCode(0x77, 1, 8, "LD (HL),A") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), cpu.ra());
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (LD (HL),nn)
        reg_op(new OpCode(0x36, 2, 12, "LD (HL),%02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            mem.w8(cpu.rhl(), arg);
        }});
        
        //8-Bit (LD A,(BC))
        reg_op(new OpCode(0x0a, 1, 8, "LD A,(BC)") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(mem.r8(cpu.rbc()));
        }});
        
        //8-Bit (LD A,(DE))
        reg_op(new OpCode(0x1a, 1, 8, "LD A,(DE)") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(mem.r8(cpu.rde()));
        }});
        
        //8-Bit (LD A,(nnnn))
        reg_op(new OpCode(0xfa, 3, 16, "LD A,(%04X)") {@Override protected void execute16(CPU cpu, Memory mem, short arg) {
            cpu.wa(mem.r8(arg));
        }});
        
        //8-Bit (LD (BC),A)
        reg_op(new OpCode(0x02, 1, 8, "LD (BC),A") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rbc(), cpu.ra());
        }});
        
        //8-Bit (LD (DE),A)
        reg_op(new OpCode(0x12, 1, 8, "LD (DE),A") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rde(), cpu.ra());
        }});
        
        //8-Bit (LD (nnnn),A)
        reg_op(new OpCode(0xea, 3, 16, "LD (%04X),A") {@Override protected void execute16(CPU cpu, Memory mem, short arg) {
            mem.w8(arg, cpu.ra());
        }});
        
        //8-Bit (LD A,(FF00 + nn))
        reg_op(new OpCode(0xf0, 2, 12, "LD A,(FF00 + %02X)") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            cpu.wa(mem.r8((short)(0xFF00 + Bin.toInt(arg))));
        }});
        
        //8-Bit (LD (FF00 + nn),A)
        reg_op(new OpCode(0xe0, 2, 12, "LD (FF00 + %02X),A") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            mem.w8((short)(0xFF00 + Bin.toInt(arg)), cpu.ra());
        }});
        
        //8-Bit (LD A,(FF00 + C))
        reg_op(new OpCode(0xf2, 1, 8, "LD A,(FF00 + C)") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(mem.r8((short)(0xFF00 + Bin.toInt(cpu.rc()))));
        }});
        
        //8-Bit (LD (FF00 + C),A)
        reg_op(new OpCode(0xe2, 1, 8, "LD (FF00 + C),A") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8((short)(0xFF00 + Bin.toInt(cpu.rc())), cpu.ra());
        }});
        
        //8-Bit (LDI (HL),A)
        reg_op(new OpCode(0x22, 1, 8, "LDI (HL),A") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), cpu.ra());
            cpu.whl((short)(cpu.rhl() + 1));
        }});
        
        //8-Bit (LDI A,(HL))
        reg_op(new OpCode(0x2a, 1, 8, "LDI A,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(mem.r8(cpu.rhl()));
            cpu.whl((short)(cpu.rhl() + 1));
        }});
        
        //8-Bit (LDD (HL),A)
        reg_op(new OpCode(0x32, 1, 8, "LDD (HL),A") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), cpu.ra());
            cpu.whl((short)(cpu.rhl() - 1));
        }});
        
        //8-Bit (LDD A,(HL))
        reg_op(new OpCode(0x3a, 1, 8, "LDD A,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(mem.r8(cpu.rhl()));
            cpu.whl((short)(cpu.rhl() - 1));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //16-Bit (LD BC,nnnn)
        reg_op(new OpCode(0x01, 3, 12, "LD BC,%04X") {@Override protected void execute16(CPU cpu, Memory mem, short arg) {
            cpu.wbc(arg);
        }});
        
        //16-Bit (LD DE,nnnn)
        reg_op(new OpCode(0x11, 3, 12, "LD DE,%04X") {@Override protected void execute16(CPU cpu, Memory mem, short arg) {
            cpu.wde(arg);
        }});
        
        //16-Bit (LD HL,nnnn)
        reg_op(new OpCode(0x21, 3, 12, "LD HL,%04X") {@Override protected void execute16(CPU cpu, Memory mem, short arg) {
            cpu.whl(arg);
        }});
        
        //16-Bit (LD SP,nnnn)
        reg_op(new OpCode(0x31, 3, 12, "LD SP,%04X") {@Override protected void execute16(CPU cpu, Memory mem, short arg) {
            cpu.wsp(arg);
        }});
        
        //16-Bit (LD (nnnn),SP)
        reg_op(new OpCode(0x08, 3, 20, "LD (%04X),SP") {@Override protected void execute16(CPU cpu, Memory mem, short arg) {
            mem.w16(arg,cpu.rsp());
        }});
        
        //16-Bit (LD SP,HL)
        reg_op(new OpCode(0xf9, 1, 8, "LD SP,HL") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wsp(cpu.rhl());
        }});
        
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //16-Bit (PUSH BC)
        reg_op(new OpCode(0xc5, 1, 16, "PUSH BC") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.push16(cpu.rbc());
        }});
        
        //16-Bit (PUSH DE)
        reg_op(new OpCode(0xd5, 1, 16, "PUSH DE") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.push16(cpu.rde());
        }});
        
        //16-Bit (PUSH HL)
        reg_op(new OpCode(0xe5, 1, 16, "PUSH HL") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.push16(cpu.rhl());
        }});
        
        //16-Bit (PUSH AF)
        reg_op(new OpCode(0xf5, 1, 16, "PUSH AF") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.push16(cpu.raf());
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //16-Bit (POP BC)
        reg_op(new OpCode(0xc1, 1, 12, "POP BC") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wbc(cpu.pop16());
        }});
        
        //16-Bit (POP DE)
        reg_op(new OpCode(0xd1, 1, 12, "POP DE") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wde(cpu.pop16());
        }});
        
        //16-Bit (POP HL)
        reg_op(new OpCode(0xe1, 1, 12, "POP HL") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.whl(cpu.pop16());
        }});
        
        //16-Bit (POP AF)
        reg_op(new OpCode(0xf1, 1, 12, "POP AF") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.waf(cpu.pop16());
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (ADD A,r)
        reg_op(new OpCode(0x80, 1, 4, "ADD A,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.add8(cpu.ra(), cpu.rb(), cpu.flags()));
        }});
        
        //8-Bit (ADD A,r)
        reg_op(new OpCode(0x81, 1, 4, "ADD A,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.add8(cpu.ra(), cpu.rc(), cpu.flags()));
        }});
        
        //8-Bit (ADD A,r)
        reg_op(new OpCode(0x82, 1, 4, "ADD A,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.add8(cpu.ra(), cpu.rd(), cpu.flags()));
        }});
        
        //8-Bit (ADD A,r)
        reg_op(new OpCode(0x83, 1, 4, "ADD A,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.add8(cpu.ra(), cpu.re(), cpu.flags()));
        }});
        
        //8-Bit (ADD A,r)
        reg_op(new OpCode(0x84, 1, 4, "ADD A,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.add8(cpu.ra(), cpu.rh(), cpu.flags()));
        }});
        
        //8-Bit (ADD A,r)
        reg_op(new OpCode(0x85, 1, 4, "ADD A,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.add8(cpu.ra(), cpu.rl(), cpu.flags()));
        }});
        
        //8-Bit (ADD A,r)
        reg_op(new OpCode(0x87, 1, 4, "ADD A,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.add8(cpu.ra(), cpu.ra(), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (ADD A,nn)
        reg_op(new OpCode(0xc6, 2, 8, "ADD A,%02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            cpu.wa(Bin.add8(cpu.ra(), arg, cpu.flags()));
        }});
        
        //8-Bit (ADD A,(HL))
        reg_op(new OpCode(0x86, 1, 8, "ADD A,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.add8(cpu.ra(), mem.r8(cpu.rhl()), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (ADC A,r)
        reg_op(new OpCode(0x88, 1, 4, "ADC A,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.adc8(cpu.ra(), cpu.rb(), cpu.flags()));
        }});
        
        //8-Bit (ADC A,r)
        reg_op(new OpCode(0x89, 1, 4, "ADC A,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.adc8(cpu.ra(), cpu.rc(), cpu.flags()));
        }});
        
        //8-Bit (ADC A,r)
        reg_op(new OpCode(0x8a, 1, 4, "ADC A,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.adc8(cpu.ra(), cpu.rd(), cpu.flags()));
        }});
        
        //8-Bit (ADC A,r)
        reg_op(new OpCode(0x8b, 1, 4, "ADC A,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.adc8(cpu.ra(), cpu.re(), cpu.flags()));
        }});
        
        //8-Bit (ADC A,r)
        reg_op(new OpCode(0x8c, 1, 4, "ADC A,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.adc8(cpu.ra(), cpu.rh(), cpu.flags()));
        }});
        
        //8-Bit (ADC A,r)
        reg_op(new OpCode(0x8d, 1, 4, "ADC A,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.adc8(cpu.ra(), cpu.rl(), cpu.flags()));
        }});
        
        //8-Bit (ADC A,r)
        reg_op(new OpCode(0x8f, 1, 4, "ADC A,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.adc8(cpu.ra(), cpu.ra(), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (ADC A,nn)
        reg_op(new OpCode(0xce, 2, 8, "ADC A,%02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            cpu.wa(Bin.adc8(cpu.ra(), arg, cpu.flags()));
        }});
        
        //8-Bit (ADC A,(HL))
        reg_op(new OpCode(0x8e, 1, 8, "ADC A,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.adc8(cpu.ra(), mem.r8(cpu.rhl()), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (SUB r)
        reg_op(new OpCode(0x90, 1, 4, "SUB B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.sub8(cpu.ra(), cpu.rb(), cpu.flags()));
        }});
        
        //8-Bit (SUB r)
        reg_op(new OpCode(0x91, 1, 4, "SUB C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.sub8(cpu.ra(), cpu.rc(), cpu.flags()));
        }});
        
        //8-Bit (SUB r)
        reg_op(new OpCode(0x92, 1, 4, "SUB D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.sub8(cpu.ra(), cpu.rd(), cpu.flags()));
        }});
        
        //8-Bit (SUB r)
        reg_op(new OpCode(0x93, 1, 4, "SUB E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.sub8(cpu.ra(), cpu.re(), cpu.flags()));
        }});
        
        //8-Bit (SUB r)
        reg_op(new OpCode(0x94, 1, 4, "SUB H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.sub8(cpu.ra(), cpu.rh(), cpu.flags()));
        }});
        
        //8-Bit (SUB r)
        reg_op(new OpCode(0x95, 1, 4, "SUB L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.sub8(cpu.ra(), cpu.rl(), cpu.flags()));
        }});
        
        //8-Bit (SUB r)
        reg_op(new OpCode(0x97, 1, 4, "SUB A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.sub8(cpu.ra(), cpu.ra(), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (SUB nn)
        reg_op(new OpCode(0xd6, 2, 8, "SUB %02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            cpu.wa(Bin.sub8(cpu.ra(), arg, cpu.flags()));
        }});
        
        //8-Bit (SUB (HL))
        reg_op(new OpCode(0x96, 1, 8, "SUB (HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.sub8(cpu.ra(), mem.r8(cpu.rhl()), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (SBC A,r)
        reg_op(new OpCode(0x98, 1, 4, "SBC A,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.sbc8(cpu.ra(), cpu.rb(), cpu.flags()));
        }});
        
        //8-Bit (SBC A,r)
        reg_op(new OpCode(0x99, 1, 4, "SBC A,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.sbc8(cpu.ra(), cpu.rc(), cpu.flags()));
        }});
        
        //8-Bit (SBC A,r)
        reg_op(new OpCode(0x9a, 1, 4, "SBC A,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.sbc8(cpu.ra(), cpu.rd(), cpu.flags()));
        }});
        
        //8-Bit (SBC A,r)
        reg_op(new OpCode(0x9b, 1, 4, "SBC A,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.sbc8(cpu.ra(), cpu.re(), cpu.flags()));
        }});
        
        //8-Bit (SBC A,r)
        reg_op(new OpCode(0x9c, 1, 4, "SBC A,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.sbc8(cpu.ra(), cpu.rh(), cpu.flags()));
        }});
        
        //8-Bit (SBC A,r)
        reg_op(new OpCode(0x9d, 1, 4, "SBC A,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.sbc8(cpu.ra(), cpu.rl(), cpu.flags()));
        }});
        
        //8-Bit (SBC A,r)
        reg_op(new OpCode(0x9f, 1, 4, "SBC A,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.sbc8(cpu.ra(), cpu.ra(), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (SBC A,nn)
        reg_op(new OpCode(0xde, 2, 8, "SBC A,%02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            cpu.wa(Bin.sbc8(cpu.ra(), arg, cpu.flags()));
        }});
        
        //8-Bit (SBC A,(HL))
        reg_op(new OpCode(0x9e, 1, 8, "SBC A,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.sbc8(cpu.ra(), mem.r8(cpu.rhl()), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (AND r)
        reg_op(new OpCode(0xa0, 1, 4, "AND B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.and8(cpu.ra(),cpu.rb(),cpu.flags()));
        }});
        
        //8-Bit (AND r)
        reg_op(new OpCode(0xa1, 1, 4, "AND C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.and8(cpu.ra(),cpu.rc(),cpu.flags()));
        }});
        
        //8-Bit (AND r)
        reg_op(new OpCode(0xa2, 1, 4, "AND D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.and8(cpu.ra(),cpu.rd(),cpu.flags()));
        }});
        
        //8-Bit (AND r)
        reg_op(new OpCode(0xa3, 1, 4, "AND E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.and8(cpu.ra(),cpu.re(),cpu.flags()));
        }});
        
        //8-Bit (AND r)
        reg_op(new OpCode(0xa4, 1, 4, "AND H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.and8(cpu.ra(),cpu.rh(),cpu.flags()));
        }});
        
        //8-Bit (AND r)
        reg_op(new OpCode(0xa5, 1, 4, "AND L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.and8(cpu.ra(),cpu.rl(),cpu.flags()));
        }});
        
        //8-Bit (AND r)
        reg_op(new OpCode(0xa7, 1, 4, "AND A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.and8(cpu.ra(),cpu.ra(),cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (AND nn)
        reg_op(new OpCode(0xe6, 2, 8, "AND %02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            cpu.wa(Bin.and8(cpu.ra(),arg,cpu.flags()));
        }});
        
        //8-Bit (AND (HL))
        reg_op(new OpCode(0xa6, 1, 8, "AND (HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.and8(cpu.ra(),mem.r8(cpu.rhl()),cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (XOR r)
        reg_op(new OpCode(0xa8, 1, 4, "XOR B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.xor8(cpu.ra(),cpu.rb(),cpu.flags()));
        }});
        
        //8-Bit (XOR r)
        reg_op(new OpCode(0xa9, 1, 4, "XOR C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.xor8(cpu.ra(),cpu.rc(),cpu.flags()));
        }});
        
        //8-Bit (XOR r)
        reg_op(new OpCode(0xaa, 1, 4, "XOR D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.xor8(cpu.ra(),cpu.rd(),cpu.flags()));
        }});
        
        //8-Bit (XOR r)
        reg_op(new OpCode(0xab, 1, 4, "XOR E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.xor8(cpu.ra(),cpu.re(),cpu.flags()));
        }});
        
        //8-Bit (XOR r)
        reg_op(new OpCode(0xac, 1, 4, "XOR H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.xor8(cpu.ra(),cpu.rh(),cpu.flags()));
        }});
        
        //8-Bit (XOR r)
        reg_op(new OpCode(0xad, 1, 4, "XOR L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.xor8(cpu.ra(),cpu.rl(),cpu.flags()));
        }});
        
        //8-Bit (XOR r)
        reg_op(new OpCode(0xaf, 1, 4, "XOR A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.xor8(cpu.ra(),cpu.ra(),cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (XOR nn)
        reg_op(new OpCode(0xee, 2, 8, "XOR %02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            cpu.wa(Bin.xor8(cpu.ra(),arg,cpu.flags()));
        }});
        
        //8-Bit (XOR (HL))
        reg_op(new OpCode(0xae, 1, 8, "XOR (HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.xor8(cpu.ra(),mem.r8(cpu.rhl()),cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (OR r)
        reg_op(new OpCode(0xb0, 1, 4, "OR B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.or8(cpu.ra(),cpu.rb(),cpu.flags()));
        }});
        
        //8-Bit (OR r)
        reg_op(new OpCode(0xb1, 1, 4, "OR C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.or8(cpu.ra(),cpu.rc(),cpu.flags()));
        }});
        
        //8-Bit (OR r)
        reg_op(new OpCode(0xb2, 1, 4, "OR D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.or8(cpu.ra(),cpu.rd(),cpu.flags()));
        }});
        
        //8-Bit (OR r)
        reg_op(new OpCode(0xb3, 1, 4, "OR E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.or8(cpu.ra(),cpu.re(),cpu.flags()));
        }});
        
        //8-Bit (OR r)
        reg_op(new OpCode(0xb4, 1, 4, "OR H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.or8(cpu.ra(),cpu.rh(),cpu.flags()));
        }});
        
        //8-Bit (OR r)
        reg_op(new OpCode(0xb5, 1, 4, "OR L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.or8(cpu.ra(),cpu.rl(),cpu.flags()));
        }});
        
        //8-Bit (OR r)
        reg_op(new OpCode(0xb7, 1, 4, "OR A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.or8(cpu.ra(),cpu.ra(),cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (OR nn)
        reg_op(new OpCode(0xf6, 2, 8, "OR %02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            cpu.wa(Bin.or8(cpu.ra(),arg,cpu.flags()));
        }});
        
        //8-Bit (OR (HL))
        reg_op(new OpCode(0xb6, 1, 8, "OR (HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.or8(cpu.ra(),mem.r8(cpu.rhl()),cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (CP r)
        reg_op(new OpCode(0xb8, 1, 4, "CP B") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.sub8(cpu.ra(), cpu.rb(), cpu.flags());
        }});
        
        //8-Bit (CP r)
        reg_op(new OpCode(0xb9, 1, 4, "CP C") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.sub8(cpu.ra(), cpu.rc(), cpu.flags());
        }});
        
        //8-Bit (CP r)
        reg_op(new OpCode(0xba, 1, 4, "CP D") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.sub8(cpu.ra(), cpu.rd(), cpu.flags());
        }});
        
        //8-Bit (CP r)
        reg_op(new OpCode(0xbb, 1, 4, "CP E") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.sub8(cpu.ra(), cpu.re(), cpu.flags());
        }});
        
        //8-Bit (CP r)
        reg_op(new OpCode(0xbc, 1, 4, "CP H") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.sub8(cpu.ra(), cpu.rh(), cpu.flags());
        }});
        
        //8-Bit (CP r)
        reg_op(new OpCode(0xbd, 1, 4, "CP L") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.sub8(cpu.ra(), cpu.rl(), cpu.flags());
        }});
        
        //8-Bit (CP r)
        reg_op(new OpCode(0xbf, 1, 4, "CP A") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.sub8(cpu.ra(), cpu.ra(), cpu.flags());
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (CP nn)
        reg_op(new OpCode(0xfe, 2, 8, "CP %02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            Bin.sub8(cpu.ra(), arg, cpu.flags());
        }});
        
        //8-Bit (CP (HL))
        reg_op(new OpCode(0xbe, 1, 8, "CP (HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.sub8(cpu.ra(), mem.r8(cpu.rhl()), cpu.flags());
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (INC r)
        reg_op(new OpCode(0x04, 1, 4, "INC B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.inc8(cpu.rb(), cpu.flags()));
        }});
        
        //8-Bit (INC r)
        reg_op(new OpCode(0x0c, 1, 4, "INC C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.inc8(cpu.rc(), cpu.flags()));
        }});
        
        //8-Bit (INC r)
        reg_op(new OpCode(0x14, 1, 4, "INC D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.inc8(cpu.rd(), cpu.flags()));
        }});
        
        //8-Bit (INC r)
        reg_op(new OpCode(0x1c, 1, 4, "INC E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.inc8(cpu.re(), cpu.flags()));
        }});
        
        //8-Bit (INC r)
        reg_op(new OpCode(0x24, 1, 4, "INC H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.inc8(cpu.rh(), cpu.flags()));
        }});
        
        //8-Bit (INC r)
        reg_op(new OpCode(0x2c, 1, 4, "INC L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.inc8(cpu.rl(), cpu.flags()));
        }});
        
        //8-Bit (INC r)
        reg_op(new OpCode(0x3c, 1, 4, "INC A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.inc8(cpu.ra(), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (INC (HL))
        reg_op(new OpCode(0x34, 1, 12, "INC (HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.inc8(mem.r8(cpu.rhl()),cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (DEC r)
        reg_op(new OpCode(0x05, 1, 4, "DEC B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.dec8(cpu.rb(), cpu.flags()));
        }});
        
        //8-Bit (DEC r)
        reg_op(new OpCode(0x0d, 1, 4, "DEC C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.dec8(cpu.rc(), cpu.flags()));
        }});
        
        //8-Bit (DEC r)
        reg_op(new OpCode(0x15, 1, 4, "DEC D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.dec8(cpu.rd(), cpu.flags()));
        }});
        
        //8-Bit (DEC r)
        reg_op(new OpCode(0x1d, 1, 4, "DEC E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.dec8(cpu.re(), cpu.flags()));
        }});
        
        //8-Bit (DEC r)
        reg_op(new OpCode(0x25, 1, 4, "DEC H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.dec8(cpu.rh(), cpu.flags()));
        }});
        
        //8-Bit (DEC r)
        reg_op(new OpCode(0x2d, 1, 4, "DEC L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.dec8(cpu.rl(), cpu.flags()));
        }});
        
        //8-Bit (DEC r)
        reg_op(new OpCode(0x3d, 1, 4, "DEC A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.dec8(cpu.ra(), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (DEC (HL))
        reg_op(new OpCode(0x35, 1, 12, "DEC (HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.dec8(mem.r8(cpu.rhl()),cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (DAA)
        reg_op(new OpCode(0x27, 1, 4, "DAA") {@Override protected void execute0(CPU cpu, Memory mem) {
            boolean n = cpu.flags().rn();
            boolean c = cpu.flags().rc();
            boolean h = cpu.flags().rh();
            
            int u = ((cpu.ra() & 0xf0) >> 4);
            int l = (cpu.ra() & 0x0f);
            
            byte _add = 0;
            boolean _c = false;
            
            if(!n) {
                if(!c) {
                         if (u >= 0x9 && u <= 0xf && !h && l >= 0x0 && l <= 0x9) {_add = 0x00; _c = false;}
                    else if (u == 0x0 &&             !h && l >= 0x0 && l <= 0x9) {_add = 0x00; _c = false;}
                    else if (u >= 0x0 && u <= 0x8 && !h && l >= 0xa && l <= 0xf) {_add = 0x06; _c = false;}
                    else if (u >= 0x0 && u <= 0x9 &&  h && l >= 0x0 && l <= 0x3) {_add = 0x06; _c = false;}
                    else if (u >= 0xa && u <= 0xf && !h && l >= 0x0 && l <= 0x9) {_add = 0x60; _c = true;}
                    else if (u >= 0x9 && u <= 0xf && !h && l >= 0xa && l <= 0xf) {_add = 0x66; _c = true;}
                    else if (u >= 0xa && u <= 0xf &&  h && l >= 0x0 && l <= 0x3) {_add = 0x66; _c = true;}
                } else {
                         if (u >= 0x0 && u <= 0x2 && !h && l >= 0x0 && l <= 0x9) {_add = 0x60; _c = true;}
                    else if (u >= 0x0 && u <= 0x2 && !h && l >= 0xa && l <= 0xf) {_add = 0x66; _c = true;}
                    else if (u >= 0x0 && u <= 0x3 &&  h && l >= 0x0 && l <= 0x3) {_add = 0x66; _c = true;}
                }
            } else {
                if(!c) {
                         if (u >= 0x0 && u <= 0x9 && !h && l >= 0x0 && l <= 0x9) {_add = 00;         _c = false;}
                    else if (u >= 0x0 && u <= 0x8 &&  h && l >= 0x6 && l <= 0xf) {_add = (byte)0xfa; _c = false;}
                } else {
                         if (u >= 0x7 && u <= 0xf && !h && l >= 0x0 && l <= 0x9) {_add = (byte)0xa0; _c = true;}
                    else if (u >= 0x6 && u <= 0x7 &&  h && l >= 0x6 && l <= 0xf) {_add = (byte)0x9a; _c = true;}
                }
            }
            
            byte result = (byte)(cpu.ra() + _add);
            cpu.wa(result);
            cpu.flags().wc(_c);
            cpu.flags().wz(result == 0);
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (CPL)
        reg_op(new OpCode(0x2f, 1, 4, "CPL") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa((byte)(~cpu.ra()));
            cpu.flags().setn();
            cpu.flags().seth();
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //16-Bit (ADD HL,rr)
        reg_op(new OpCode(0x09, 1, 8, "ADD HL,BC") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.whl(Bin.add16woz(cpu.rhl(), cpu.rbc(), cpu.flags()));
        }});
        
        //16-Bit (ADD HL,rr)
        reg_op(new OpCode(0x19, 1, 8, "ADD HL,DE") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.whl(Bin.add16woz(cpu.rhl(), cpu.rde(), cpu.flags()));
        }});
        
        //16-Bit (ADD HL,rr)
        reg_op(new OpCode(0x29, 1, 8, "ADD HL,HL") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.whl(Bin.add16woz(cpu.rhl(), cpu.rhl(), cpu.flags()));
        }});
        
        //16-Bit (ADD HL,rr)
        reg_op(new OpCode(0x39, 1, 8, "ADD HL,SP") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.whl(Bin.add16woz(cpu.rhl(), cpu.rsp(), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //16-Bit (INC rr)
        reg_op(new OpCode(0x03, 1, 8, "INC BC") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wbc((short)(cpu.rbc() + 1));
        }});
        
        //16-Bit (INC rr)
        reg_op(new OpCode(0x13, 1, 8, "INC DE") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wde((short)(cpu.rde() + 1));
        }});
        
        //16-Bit (INC rr)
        reg_op(new OpCode(0x23, 1, 8, "INC HL") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.whl((short)(cpu.rhl() + 1));
        }});
        
        //16-Bit (INC rr)
        reg_op(new OpCode(0x33, 1, 8, "INC BC") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wsp((short)(cpu.rsp() + 1));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //16-Bit (DEC rr)
        reg_op(new OpCode(0x0b, 1, 8, "DEC BC") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wbc((short)(cpu.rbc() - 1));
        }});
        
        //16-Bit (DEC rr)
        reg_op(new OpCode(0x1b, 1, 8, "DEC DE") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wde((short)(cpu.rde() - 1));
        }});
        
        //16-Bit (DEC rr)
        reg_op(new OpCode(0x2b, 1, 8, "DEC HL") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.whl((short)(cpu.rhl() - 1));
        }});
        
        //16-Bit (DEC rr)
        reg_op(new OpCode(0x3b, 1, 8, "DEC BC") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wsp((short)(cpu.rsp() - 1));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //16-Bit (ADD SP,nn)
        reg_op(new OpCode(0xe8, 2, 16, "ADD SP,%02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            cpu.wsp(Bin.add16Signed8cz(cpu.rsp(), arg, cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //16-Bit (LD HL,SP+nn)
        reg_op(new OpCode(0xf8, 2, 12, "LD HL,SP+%02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            cpu.whl(Bin.add16Signed8cz(cpu.rsp(), arg, cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (RLCA)
        reg_op(new OpCode(0x07, 1, 4, "RLCA") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.rlc8(cpu.ra(), cpu.flags()));
            cpu.flags().clrz();
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (RLA)
        reg_op(new OpCode(0x17, 1, 4, "RLA") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.rl8(cpu.ra(), cpu.flags()));
            cpu.flags().clrz();
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (RLCA)
        reg_op(new OpCode(0x0f, 1, 4, "RRCA") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.rrc8(cpu.ra(), cpu.flags()));
            cpu.flags().clrz();
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (RRA)
        reg_op(new OpCode(0x1f, 1, 4, "RRA") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.rr8(cpu.ra(), cpu.flags()));
            cpu.flags().clrz();
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (RLC r)
        reg_op(new OpCode(0xcb00, 2, 8, "RLC B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.rlc8(cpu.rb(), cpu.flags()));
        }});
        
        //8-Bit (RLC r)
        reg_op(new OpCode(0xcb01, 2, 8, "RLC C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.rlc8(cpu.rc(), cpu.flags()));
        }});
        
        //8-Bit (RLC r)
        reg_op(new OpCode(0xcb02, 2, 8, "RLC D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.rlc8(cpu.rd(), cpu.flags()));
        }});
        
        //8-Bit (RLC r)
        reg_op(new OpCode(0xcb03, 2, 8, "RLC E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.rlc8(cpu.re(), cpu.flags()));
        }});
        
        //8-Bit (RLC r)
        reg_op(new OpCode(0xcb04, 2, 8, "RLC H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.rlc8(cpu.rh(), cpu.flags()));
        }});
        
        //8-Bit (RLC r)
        reg_op(new OpCode(0xcb05, 2, 8, "RLC L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.rlc8(cpu.rl(), cpu.flags()));
        }});
        
        //8-Bit (RLC r)
        reg_op(new OpCode(0xcb07, 2, 8, "RLC A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.rlc8(cpu.ra(), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (RLC (HL))
        reg_op(new OpCode(0xcb06, 2, 16, "RLC (HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.rlc8(mem.r8(cpu.rh()), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (RL r)
        reg_op(new OpCode(0xcb10, 2, 8, "RL B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.rl8(cpu.rb(), cpu.flags()));
        }});
        
        //8-Bit (RL r)
        reg_op(new OpCode(0xcb11, 2, 8, "RL C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.rl8(cpu.rc(), cpu.flags()));
        }});
        
        //8-Bit (RL r)
        reg_op(new OpCode(0xcb12, 2, 8, "RL D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.rl8(cpu.rd(), cpu.flags()));
        }});
        
        //8-Bit (RL r)
        reg_op(new OpCode(0xcb13, 2, 8, "RL E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.rl8(cpu.re(), cpu.flags()));
        }});
        
        //8-Bit (RL r)
        reg_op(new OpCode(0xcb14, 2, 8, "RL H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.rl8(cpu.rh(), cpu.flags()));
        }});
        
        //8-Bit (RL r)
        reg_op(new OpCode(0xcb15, 2, 8, "RL L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.rl8(cpu.rl(), cpu.flags()));
        }});
        
        //8-Bit (RL r)
        reg_op(new OpCode(0xcb17, 2, 8, "RL A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.rl8(cpu.ra(), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (RL (HL))
        reg_op(new OpCode(0xcb16, 2, 16, "RL (HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.rl8(mem.r8(cpu.rh()), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (RRC r)
        reg_op(new OpCode(0xcb08, 2, 8, "RRC B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.rrc8(cpu.rb(), cpu.flags()));
        }});
        
        //8-Bit (RRC r)
        reg_op(new OpCode(0xcb09, 2, 8, "RRC C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.rrc8(cpu.rc(), cpu.flags()));
        }});
        
        //8-Bit (RRC r)
        reg_op(new OpCode(0xcb0a, 2, 8, "RRC D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.rrc8(cpu.rd(), cpu.flags()));
        }});
        
        //8-Bit (RRC r)
        reg_op(new OpCode(0xcb0b, 2, 8, "RRC E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.rrc8(cpu.re(), cpu.flags()));
        }});
        
        //8-Bit (RRC r)
        reg_op(new OpCode(0xcb0c, 2, 8, "RRC H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.rrc8(cpu.rh(), cpu.flags()));
        }});
        
        //8-Bit (RRC r)
        reg_op(new OpCode(0xcb0d, 2, 8, "RRC L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.rrc8(cpu.rl(), cpu.flags()));
        }});
        
        //8-Bit (RRC r)
        reg_op(new OpCode(0xcb0f, 2, 8, "RRC A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.rrc8(cpu.ra(), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (RRC (HL))
        reg_op(new OpCode(0xcb0e, 2, 16, "RRC (HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.rrc8(mem.r8(cpu.rh()), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (RR r)
        reg_op(new OpCode(0xcb18, 2, 8, "RR B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.rr8(cpu.rb(), cpu.flags()));
        }});
        
        //8-Bit (RR r)
        reg_op(new OpCode(0xcb19, 2, 8, "RR C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.rr8(cpu.rc(), cpu.flags()));
        }});
        
        //8-Bit (RR r)
        reg_op(new OpCode(0xcb1a, 2, 8, "RR D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.rr8(cpu.rd(), cpu.flags()));
        }});
        
        //8-Bit (RR r)
        reg_op(new OpCode(0xcb1b, 2, 8, "RR E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.rr8(cpu.re(), cpu.flags()));
        }});
        
        //8-Bit (RR r)
        reg_op(new OpCode(0xcb1c, 2, 8, "RR H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.rr8(cpu.rh(), cpu.flags()));
        }});
        
        //8-Bit (RR r)
        reg_op(new OpCode(0xcb1d, 2, 8, "RR L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.rr8(cpu.rl(), cpu.flags()));
        }});
        
        //8-Bit (RR r)
        reg_op(new OpCode(0xcb1f, 2, 8, "RR A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.rr8(cpu.ra(), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (RR (HL))
        reg_op(new OpCode(0xcb1e, 2, 16, "RR (HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.rr8(mem.r8(cpu.rh()), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (SLA r)
        reg_op(new OpCode(0xcb20, 2, 8, "SLA B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.sla8(cpu.rb(), cpu.flags()));
        }});
        
        //8-Bit (SLA r)
        reg_op(new OpCode(0xcb21, 2, 8, "SLA C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.sla8(cpu.rc(), cpu.flags()));
        }});
        
        //8-Bit (SLA r)
        reg_op(new OpCode(0xcb22, 2, 8, "SLA D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.sla8(cpu.rd(), cpu.flags()));
        }});
        
        //8-Bit (SLA r)
        reg_op(new OpCode(0xcb23, 2, 8, "SLA E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.sla8(cpu.re(), cpu.flags()));
        }});
        
        //8-Bit (SLA r)
        reg_op(new OpCode(0xcb24, 2, 8, "SLA H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.sla8(cpu.rh(), cpu.flags()));
        }});
        
        //8-Bit (SLA r)
        reg_op(new OpCode(0xcb25, 2, 8, "SLA L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.sla8(cpu.rl(), cpu.flags()));
        }});
        
        //8-Bit (SLA r)
        reg_op(new OpCode(0xcb27, 2, 8, "SLA A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.sla8(cpu.ra(), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (SLA (HL))
        reg_op(new OpCode(0xcb26, 2, 16, "SLA (HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.sla8(mem.r8(cpu.rh()), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (SWAP r)
        reg_op(new OpCode(0xcb30, 2, 8, "SWAP B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.swap8(cpu.rb(), cpu.flags()));
        }});
        
        //8-Bit (SWAP r)
        reg_op(new OpCode(0xcb31, 2, 8, "SWAP C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.swap8(cpu.rc(), cpu.flags()));
        }});
        
        //8-Bit (SWAP r)
        reg_op(new OpCode(0xcb32, 2, 8, "SWAP D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.swap8(cpu.rd(), cpu.flags()));
        }});
        
        //8-Bit (SWAP r)
        reg_op(new OpCode(0xcb33, 2, 8, "SWAP E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.swap8(cpu.re(), cpu.flags()));
        }});
        
        //8-Bit (SWAP r)
        reg_op(new OpCode(0xcb34, 2, 8, "SWAP H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.swap8(cpu.rh(), cpu.flags()));
        }});
        
        //8-Bit (SWAP r)
        reg_op(new OpCode(0xcb35, 2, 8, "SWAP L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.swap8(cpu.rl(), cpu.flags()));
        }});
        
        //8-Bit (SWAP r)
        reg_op(new OpCode(0xcb37, 2, 8, "SWAP A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.swap8(cpu.ra(), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (SWAP (HL))
        reg_op(new OpCode(0xcb36, 2, 16, "SWAP (HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.swap8(mem.r8(cpu.rh()), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (SRA r)
        reg_op(new OpCode(0xcb28, 2, 8, "SRA B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.sra8(cpu.rb(), cpu.flags()));
        }});
        
        //8-Bit (SRA r)
        reg_op(new OpCode(0xcb29, 2, 8, "SRA C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.sra8(cpu.rc(), cpu.flags()));
        }});
        
        //8-Bit (SRA r)
        reg_op(new OpCode(0xcb2a, 2, 8, "SRA D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.sra8(cpu.rd(), cpu.flags()));
        }});
        
        //8-Bit (SRA r)
        reg_op(new OpCode(0xcb2b, 2, 8, "SRA E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.sra8(cpu.re(), cpu.flags()));
        }});
        
        //8-Bit (SRA r)
        reg_op(new OpCode(0xcb2c, 2, 8, "SRA H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.sra8(cpu.rh(), cpu.flags()));
        }});
        
        //8-Bit (SRA r)
        reg_op(new OpCode(0xcb2d, 2, 8, "SRA L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.sra8(cpu.rl(), cpu.flags()));
        }});
        
        //8-Bit (SRA r)
        reg_op(new OpCode(0xcb2f, 2, 8, "SRA A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.sra8(cpu.ra(), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (SRA (HL))
        reg_op(new OpCode(0xcb2e, 2, 16, "SRA (HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.sra8(mem.r8(cpu.rh()), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (SRL r)
        reg_op(new OpCode(0xcb38, 2, 8, "SRL B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.srl8(cpu.rb(), cpu.flags()));
        }});
        
        //8-Bit (SRL r)
        reg_op(new OpCode(0xcb39, 2, 8, "SRL C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.srl8(cpu.rc(), cpu.flags()));
        }});
        
        //8-Bit (SRL r)
        reg_op(new OpCode(0xcb3a, 2, 8, "SRL D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.srl8(cpu.rd(), cpu.flags()));
        }});
        
        //8-Bit (SRL r)
        reg_op(new OpCode(0xcb3b, 2, 8, "SRL E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.srl8(cpu.re(), cpu.flags()));
        }});
        
        //8-Bit (SRL r)
        reg_op(new OpCode(0xcb3c, 2, 8, "SRL H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.srl8(cpu.rh(), cpu.flags()));
        }});
        
        //8-Bit (SRL r)
        reg_op(new OpCode(0xcb3d, 2, 8, "SRL L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.srl8(cpu.rl(), cpu.flags()));
        }});
        
        //8-Bit (SRL r)
        reg_op(new OpCode(0xcb3f, 2, 8, "SRL A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.srl8(cpu.ra(), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (SRL (HL))
        reg_op(new OpCode(0xcb3e, 2, 16, "SRL (HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.srl8(mem.r8(cpu.rh()), cpu.flags()));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb40, 2, 8, "BIT 0,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rb(), 0, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb41, 2, 8, "BIT 0,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rc(), 0, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb42, 2, 8, "BIT 0,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rd(), 0, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb43, 2, 8, "BIT 0,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.re(), 0, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb44, 2, 8, "BIT 0,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rh(), 0, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb45, 2, 8, "BIT 0,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rl(), 0, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb46, 2, 16, "BIT 0,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(mem.r8(cpu.rhl()), 0, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb47, 2, 8, "BIT 0,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.ra(), 0, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb48, 2, 8, "BIT 1,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rb(), 1, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb49, 2, 8, "BIT 1,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rc(), 1, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb4a, 2, 8, "BIT 1,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rd(), 1, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb4b, 2, 8, "BIT 1,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.re(), 1, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb4c, 2, 8, "BIT 1,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rh(), 1, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb4d, 2, 8, "BIT 1,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rl(), 1, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb4e, 2, 16, "BIT 1,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(mem.r8(cpu.rhl()), 1, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb4f, 2, 8, "BIT 1,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.ra(), 1, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb50, 2, 8, "BIT 2,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rb(), 2, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb51, 2, 8, "BIT 2,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rc(), 2, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb52, 2, 8, "BIT 2,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rd(), 2, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb53, 2, 8, "BIT 2,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.re(), 2, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb54, 2, 8, "BIT 2,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rh(), 2, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb55, 2, 8, "BIT 2,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rl(), 2, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb56, 2, 16, "BIT 2,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(mem.r8(cpu.rhl()), 2, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb57, 2, 8, "BIT 2,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.ra(), 2, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb58, 2, 8, "BIT 3,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rb(), 3, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb59, 2, 8, "BIT 3,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rc(), 3, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb5a, 2, 8, "BIT 3,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rd(), 3, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb5b, 2, 8, "BIT 3,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.re(), 3, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb5c, 2, 8, "BIT 3,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rh(), 3, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb5d, 2, 8, "BIT 3,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rl(), 3, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb5e, 2, 16, "BIT 3,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(mem.r8(cpu.rhl()), 3, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb5f, 2, 8, "BIT 3,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.ra(), 3, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb60, 2, 8, "BIT 4,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rb(), 4, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb61, 2, 8, "BIT 4,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rc(), 4, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb62, 2, 8, "BIT 4,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rd(), 4, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb63, 2, 8, "BIT 4,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.re(), 4, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb64, 2, 8, "BIT 4,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rh(), 4, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb65, 2, 8, "BIT 4,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rl(), 4, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb66, 2, 16, "BIT 4,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(mem.r8(cpu.rhl()), 4, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb67, 2, 8, "BIT 4,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.ra(), 4, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb68, 2, 8, "BIT 5,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rb(), 5, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb69, 2, 8, "BIT 5,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rc(), 5, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb6a, 2, 8, "BIT 5,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rd(), 5, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb6b, 2, 8, "BIT 5,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.re(), 5, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb6c, 2, 8, "BIT 5,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rh(), 5, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb6d, 2, 8, "BIT 5,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rl(), 5, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb6e, 2, 16, "BIT 5,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(mem.r8(cpu.rhl()), 5, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb6f, 2, 8, "BIT 5,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.ra(), 5, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb70, 2, 8, "BIT 6,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rb(), 6, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb71, 2, 8, "BIT 6,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rc(), 6, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb72, 2, 8, "BIT 6,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rd(), 6, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb73, 2, 8, "BIT 6,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.re(), 6, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb74, 2, 8, "BIT 6,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rh(), 6, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb75, 2, 8, "BIT 6,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rl(), 6, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb76, 2, 16, "BIT 6,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(mem.r8(cpu.rhl()), 6, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb77, 2, 8, "BIT 6,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.ra(), 6, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb78, 2, 8, "BIT 7,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rb(), 7, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb79, 2, 8, "BIT 7,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rc(), 7, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb7a, 2, 8, "BIT 7,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rd(), 7, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb7b, 2, 8, "BIT 7,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.re(), 7, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb7c, 2, 8, "BIT 7,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rh(), 7, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb7d, 2, 8, "BIT 7,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.rl(), 7, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb7e, 2, 16, "BIT 7,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(mem.r8(cpu.rhl()), 7, cpu.flags());
        }});
        
        //8-Bit (BIT n,r)
        reg_op(new OpCode(0xcb7f, 2, 8, "BIT 7,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            Bin.bit8(cpu.ra(), 7, cpu.flags());
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbc0, 2, 8, "SET 0,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.set8(cpu.rb(), 0));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbc1, 2, 8, "SET 0,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.set8(cpu.rc(), 0));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbc2, 2, 8, "SET 0,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.set8(cpu.rd(), 0));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbc3, 2, 8, "SET 0,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.set8(cpu.re(), 0));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbc4, 2, 8, "SET 0,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.set8(cpu.rh(), 0));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbc5, 2, 8, "SET 0,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.set8(cpu.rl(), 0));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbc6, 2, 16, "SET 0,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rh(),Bin.set8(mem.r8(cpu.rhl()), 0));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbc7, 2, 8, "SET 0,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.set8(cpu.ra(), 0));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbc8, 2, 8, "SET 1,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.set8(cpu.rb(), 1));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbc9, 2, 8, "SET 1,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.set8(cpu.rc(), 1));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbca, 2, 8, "SET 1,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.set8(cpu.rd(), 1));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbcb, 2, 8, "SET 1,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.set8(cpu.re(), 1));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbcc, 2, 8, "SET 1,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.set8(cpu.rh(), 1));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbcd, 2, 8, "SET 1,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.set8(cpu.rl(), 1));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbce, 2, 16, "SET 1,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.set8(mem.r8(cpu.rhl()), 1));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbcf, 2, 8, "SET 1,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.set8(cpu.ra(), 1));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbd0, 2, 8, "SET 2,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.set8(cpu.rb(), 2));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbd1, 2, 8, "SET 2,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.set8(cpu.rc(), 2));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbd2, 2, 8, "SET 2,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.set8(cpu.rd(), 2));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbd3, 2, 8, "SET 2,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.set8(cpu.re(), 2));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbd4, 2, 8, "SET 2,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.set8(cpu.rh(), 2));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbd5, 2, 8, "SET 2,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.set8(cpu.rl(), 2));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbd6, 2, 16, "SET 2,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.set8(mem.r8(cpu.rhl()), 2));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbd7, 2, 8, "SET 2,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.set8(cpu.ra(), 2));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbd8, 2, 8, "SET 3,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.set8(cpu.rb(), 3));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbd9, 2, 8, "SET 3,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.set8(cpu.rc(), 3));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbda, 2, 8, "SET 3,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.set8(cpu.rd(), 3));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbdb, 2, 8, "SET 3,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.set8(cpu.re(), 3));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbdc, 2, 8, "SET 3,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.set8(cpu.rh(), 3));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbdd, 2, 8, "SET 3,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.set8(cpu.rl(), 3));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbde, 2, 16, "SET 3,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.set8(mem.r8(cpu.rhl()), 3));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbdf, 2, 8, "SET 3,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.set8(cpu.ra(), 3));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbe0, 2, 8, "SET 4,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.set8(cpu.rb(), 4));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbe1, 2, 8, "SET 4,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.set8(cpu.rc(), 4));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbe2, 2, 8, "SET 4,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.set8(cpu.rd(), 4));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbe3, 2, 8, "SET 4,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.set8(cpu.re(), 4));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbe4, 2, 8, "SET 4,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.set8(cpu.rh(), 4));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbe5, 2, 8, "SET 4,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.set8(cpu.rl(), 4));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbe6, 2, 16, "SET 4,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.set8(mem.r8(cpu.rhl()), 4));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbe7, 2, 8, "SET 4,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.set8(cpu.ra(), 4));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbe8, 2, 8, "SET 5,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.set8(cpu.rb(), 5));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbe9, 2, 8, "SET 5,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.set8(cpu.rc(), 5));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbea, 2, 8, "SET 5,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.set8(cpu.rd(), 5));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbeb, 2, 8, "SET 5,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.set8(cpu.re(), 5));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbec, 2, 8, "SET 5,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.set8(cpu.rh(), 5));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbed, 2, 8, "SET 5,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.set8(cpu.rl(), 5));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbee, 2, 16, "SET 5,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.set8(mem.r8(cpu.rhl()), 5));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbef, 2, 8, "SET 5,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.set8(cpu.ra(), 5));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbf0, 2, 8, "SET 6,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.set8(cpu.rb(), 6));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbf1, 2, 8, "SET 6,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.set8(cpu.rc(), 6));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbf2, 2, 8, "SET 6,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.set8(cpu.rd(), 6));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbf3, 2, 8, "SET 6,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.set8(cpu.re(), 6));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbf4, 2, 8, "SET 6,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.set8(cpu.rh(), 6));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbf5, 2, 8, "SET 6,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.set8(cpu.rl(), 6));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbf6, 2, 16, "SET 6,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.set8(mem.r8(cpu.rhl()), 6));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbf7, 2, 8, "SET 6,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.set8(cpu.ra(), 6));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbf8, 2, 8, "SET 7,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.set8(cpu.rb(), 7));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbf9, 2, 8, "SET 7,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.set8(cpu.rc(), 7));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbfa, 2, 8, "SET 7,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.set8(cpu.rd(), 7));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbfb, 2, 8, "SET 7,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.set8(cpu.re(), 7));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbfc, 2, 8, "SET 7,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.set8(cpu.rh(), 7));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbfd, 2, 8, "SET 7,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.set8(cpu.rl(), 7));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbfe, 2, 16, "SET 7,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(),Bin.set8(mem.r8(cpu.rhl()), 7));
        }});
        
        //8-Bit (SET n,r)
        reg_op(new OpCode(0xcbff, 2, 8, "SET 7,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.set8(cpu.ra(), 7));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb80, 2, 8, "RES 0,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.res8(cpu.rb(), 0));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb81, 2, 8, "RES 0,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.res8(cpu.rc(), 0));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb82, 2, 8, "RES 0,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.res8(cpu.rd(), 0));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb83, 2, 8, "RES 0,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.res8(cpu.re(), 0));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb84, 2, 8, "RES 0,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.res8(cpu.rh(), 0));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb85, 2, 8, "RES 0,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.res8(cpu.rl(), 0));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb86, 2, 16, "RES 0,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rh(),Bin.res8(mem.r8(cpu.rhl()), 0));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb87, 2, 8, "RES 0,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.res8(cpu.ra(), 0));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb88, 2, 8, "RES 1,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.res8(cpu.rb(), 1));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb89, 2, 8, "RES 1,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.res8(cpu.rc(), 1));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb8a, 2, 8, "RES 1,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.res8(cpu.rd(), 1));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb8b, 2, 8, "RES 1,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.res8(cpu.re(), 1));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb8c, 2, 8, "RES 1,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.res8(cpu.rh(), 1));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb8d, 2, 8, "RES 1,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.res8(cpu.rl(), 1));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb8e, 2, 16, "RES 1,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.res8(mem.r8(cpu.rhl()), 1));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb8f, 2, 8, "RES 1,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.res8(cpu.ra(), 1));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb90, 2, 8, "RES 2,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.res8(cpu.rb(), 2));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb91, 2, 8, "RES 2,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.res8(cpu.rc(), 2));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb92, 2, 8, "RES 2,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.res8(cpu.rd(), 2));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb93, 2, 8, "RES 2,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.res8(cpu.re(), 2));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb94, 2, 8, "RES 2,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.res8(cpu.rh(), 2));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb95, 2, 8, "RES 2,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.res8(cpu.rl(), 2));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb96, 2, 16, "RES 2,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.res8(mem.r8(cpu.rhl()), 2));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb97, 2, 8, "RES 2,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.res8(cpu.ra(), 2));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb98, 2, 8, "RES 3,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.res8(cpu.rb(), 3));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb99, 2, 8, "RES 3,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.res8(cpu.rc(), 3));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb9a, 2, 8, "RES 3,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.res8(cpu.rd(), 3));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb9b, 2, 8, "RES 3,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.res8(cpu.re(), 3));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb9c, 2, 8, "RES 3,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.res8(cpu.rh(), 3));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb9d, 2, 8, "RES 3,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.res8(cpu.rl(), 3));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb9e, 2, 16, "RES 3,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.res8(mem.r8(cpu.rhl()), 3));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcb9f, 2, 8, "RES 3,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.res8(cpu.ra(), 3));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcba0, 2, 8, "RES 4,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.res8(cpu.rb(), 4));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcba1, 2, 8, "RES 4,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.res8(cpu.rc(), 4));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcba2, 2, 8, "RES 4,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.res8(cpu.rd(), 4));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcba3, 2, 8, "RES 4,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.res8(cpu.re(), 4));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcba4, 2, 8, "RES 4,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.res8(cpu.rh(), 4));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcba5, 2, 8, "RES 4,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.res8(cpu.rl(), 4));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcba6, 2, 16, "RES 4,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.res8(mem.r8(cpu.rhl()), 4));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcba7, 2, 8, "RES 4,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.res8(cpu.ra(), 4));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcba8, 2, 8, "RES 5,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.res8(cpu.rb(), 5));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcba9, 2, 8, "RES 5,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.res8(cpu.rc(), 5));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbaa, 2, 8, "RES 5,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.res8(cpu.rd(), 5));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbab, 2, 8, "RES 5,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.res8(cpu.re(), 5));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbac, 2, 8, "RES 5,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.res8(cpu.rh(), 5));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbad, 2, 8, "RES 5,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.res8(cpu.rl(), 5));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbae, 2, 16, "RES 5,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.res8(mem.r8(cpu.rhl()), 5));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbaf, 2, 8, "RES 5,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.res8(cpu.ra(), 5));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbb0, 2, 8, "RES 6,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.res8(cpu.rb(), 6));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbb1, 2, 8, "RES 6,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.res8(cpu.rc(), 6));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbb2, 2, 8, "RES 6,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.res8(cpu.rd(), 6));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbb3, 2, 8, "RES 6,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.res8(cpu.re(), 6));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbb4, 2, 8, "RES 6,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.res8(cpu.rh(), 6));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbb5, 2, 8, "RES 6,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.res8(cpu.rl(), 6));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbb6, 2, 16, "RES 6,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(), Bin.res8(mem.r8(cpu.rhl()), 6));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbb7, 2, 8, "RES 6,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.res8(cpu.ra(), 6));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbb8, 2, 8, "RES 7,B") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wb(Bin.res8(cpu.rb(), 7));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbb9, 2, 8, "RES 7,C") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wc(Bin.res8(cpu.rc(), 7));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbba, 2, 8, "RES 7,D") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wd(Bin.res8(cpu.rd(), 7));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbbb, 2, 8, "RES 7,E") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.we(Bin.res8(cpu.re(), 7));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbbc, 2, 8, "RES 7,H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wh(Bin.res8(cpu.rh(), 7));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbbd, 2, 8, "RES 7,L") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wl(Bin.res8(cpu.rl(), 7));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbbe, 2, 16, "RES 7,(HL)") {@Override protected void execute0(CPU cpu, Memory mem) {
            mem.w8(cpu.rhl(),Bin.res8(mem.r8(cpu.rhl()), 7));
        }});
        
        //8-Bit (RES n,r)
        reg_op(new OpCode(0xcbbf, 2, 8, "RES 7,A") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wa(Bin.res8(cpu.ra(), 7));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //(CCF)
        reg_op(new OpCode(0x3f, 1, 4, "CCF") {@Override protected void execute0(CPU cpu, Memory mem) {
            Flags f = cpu.flags();
            f.clrn();
            f.clrh();
            f.wc(f.rc() ? false : true);
        }});
        
        //(SCF)
        reg_op(new OpCode(0x37, 1, 4, "SCF") {@Override protected void execute0(CPU cpu, Memory mem) {
            Flags f = cpu.flags();
            f.clrn();
            f.clrh();
            f.setc();
        }});
        
        //(NOP)
        reg_op(new OpCode(0x00, 1, 4, "NOP") {@Override protected void execute0(CPU cpu, Memory mem) {
            //NOP
        }});
        
        //(HALT)
        reg_op(new OpCode(0x76, 1, 4, "HALT") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.halt();
        }});
        
        //(STOP)
        reg_op(new OpCode(0x10, 2, 4, "STOP") {@Override protected void execute8(CPU cpu, Memory mem, byte arg /*Will Always be 0x00*/) {
            cpu.stop();
            cpu.setIME(true);
        }});
        
        //(DI)
        reg_op(new OpCode(0xf3, 1, 4, "DI") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.di();
        }});
        
        //(EI)
        reg_op(new OpCode(0xfb, 1, 4, "EI") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.ei();
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //(JP nnnn)
        reg_op(new OpCode(0xc3, 3, 0, 16, "JP %04X") {@Override protected void execute16(CPU cpu, Memory mem, short arg) {
            cpu.wpc(arg);
        }});
        
        //(JP HL)
        reg_op(new OpCode(0xe9, 1, 0, 4, "JP HL") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wpc(cpu.rhl());
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //(JP f,nnnn)
        reg_op(new OpCode(0xc2, 3, 12, 16, "JP NZ,%04X") {@Override protected void execute16(CPU cpu, Memory mem, short arg) {
            if(!cpu.flags().rz()) cpu.wpc(arg);
        }});
        
        //(JP f,nnnn)
        reg_op(new OpCode(0xca, 3, 12, 16, "JP Z,%04X") {@Override protected void execute16(CPU cpu, Memory mem, short arg) {
            if(cpu.flags().rz()) cpu.wpc(arg);
        }});
        
        //(JP f,nnnn)
        reg_op(new OpCode(0xd2, 3, 12, 16, "JP NC,%04X") {@Override protected void execute16(CPU cpu, Memory mem, short arg) {
            if(!cpu.flags().rc()) cpu.wpc(arg);
        }});
        
        //(JP f,nnnn)
        reg_op(new OpCode(0xda, 3, 12, 16, "JP C,%04X") {@Override protected void execute16(CPU cpu, Memory mem, short arg) {
            if(!cpu.flags().rc()) cpu.wpc(arg);
        }});
        
        //(JR PC+nn)
        reg_op(new OpCode(0x18, 2, 0, 12, "JR PC+%02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            cpu.wpc((short)(Bin.toInt(cpu.rpc()) + (int)arg + 2));
        }});
        
        //(JR f,PC+nn)
        reg_op(new OpCode(0x20, 2, 8, 12, "JR NZ,PC+%02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            if(!cpu.flags().rz()) cpu.wpc((short)(Bin.toInt(cpu.rpc()) + (int)arg + 2));
        }});
        
        //(JR f,PC+nn)
        reg_op(new OpCode(0x28, 2, 8, 12, "JR Z,PC+%02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            if(cpu.flags().rz()) cpu.wpc((short)(Bin.toInt(cpu.rpc()) + (int)arg + 2));
        }});
        
        //(JR f,PC+nn)
        reg_op(new OpCode(0x30, 2, 8, 12, "JR NC,PC+%02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            if(!cpu.flags().rc()) cpu.wpc((short)(Bin.toInt(cpu.rpc()) + (int)arg + 2));
        }});
        
        //(JR f,PC+nn)
        reg_op(new OpCode(0x38, 2, 8, 12, "JR C,PC+%02X") {@Override protected void execute8(CPU cpu, Memory mem, byte arg) {
            if(cpu.flags().rc()) cpu.wpc((short)(Bin.toInt(cpu.rpc()) + (int)arg + 2));
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //(CALL nnnn)
        reg_op(new OpCode(0xcd, 3, 0, 24, "CALL %04X") {@Override protected void execute16(CPU cpu, Memory mem, short arg) {
            cpu.push16((short)(cpu.rpc() + 3));
            cpu.wpc(arg);
        }});
        
        //(CALL f,nnnn)
        reg_op(new OpCode(0xc4, 3, 12, 24, "CALL NZ,%04X") {@Override protected void execute16(CPU cpu, Memory mem, short arg) {
            if(!cpu.flags().rz()) {
                cpu.push16((short)(cpu.rpc() + 3));
                cpu.wpc(arg);
            }
        }});
        
        //(CALL f,nnnn)
        reg_op(new OpCode(0xcc, 3, 12, 24, "CALL Z,%04X") {@Override protected void execute16(CPU cpu, Memory mem, short arg) {
            if(cpu.flags().rz()) {
                cpu.push16((short)(cpu.rpc() + 3));
                cpu.wpc(arg);
            }
        }});
        
        //(CALL f,nnnn)
        reg_op(new OpCode(0xd4, 3, 12, 24, "CALL NC,%04X") {@Override protected void execute16(CPU cpu, Memory mem, short arg) {
            if(!cpu.flags().rc()) {
                cpu.push16((short)(cpu.rpc() + 3));
                cpu.wpc(arg);
            }
        }});
        
        //(CALL f,nnnn)
        reg_op(new OpCode(0xdc, 3, 12, 24, "CALL C,%04X") {@Override protected void execute16(CPU cpu, Memory mem, short arg) {
            if(cpu.flags().rc()) {
                cpu.push16((short)(cpu.rpc() + 3));
                cpu.wpc(arg);
            }
        }});
        
        //----------------------------------------------------------------------
        //----------------------------------------------------------------------
        
        //(RET)
        reg_op(new OpCode(0xc9, 1, 0, 16, "RET") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.wpc(cpu.pop16());
        }});
        
        //(RET F)
        reg_op(new OpCode(0xc0, 1, 8, 20, "RET NZ") {@Override protected void execute0(CPU cpu, Memory mem) {
            if(!cpu.flags().rz()) cpu.wpc(cpu.pop16());
        }});
        
        //(RET F)
        reg_op(new OpCode(0xc8, 1, 8, 20, "RET Z") {@Override protected void execute0(CPU cpu, Memory mem) {
            if(cpu.flags().rz()) cpu.wpc(cpu.pop16());
        }});
        
        //(RET F)
        reg_op(new OpCode(0xd0, 1, 8, 20, "RET NC") {@Override protected void execute0(CPU cpu, Memory mem) {
            if(!cpu.flags().rc()) cpu.wpc(cpu.pop16());
        }});
        
        //(RET F)
        reg_op(new OpCode(0xd8, 1, 8, 20, "RET C") {@Override protected void execute0(CPU cpu, Memory mem) {
            if(cpu.flags().rc()) cpu.wpc(cpu.pop16());
        }});
        
        //(RETI)
        reg_op(new OpCode(0xd9, 1, 0, 16, "RETI") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.setIME(true);
            cpu.wpc(cpu.pop16());
        }});
        
        //(RST nn)
        reg_op(new OpCode(0xc7, 1, 0, 16, "RST 00H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.push16((short)(cpu.rpc() + 1));
            cpu.wpc((short)0x0000);
        }});
        
        //(RST nn)
        reg_op(new OpCode(0xcf, 1, 0, 16, "RST 08H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.push16((short)(cpu.rpc() + 1));
            cpu.wpc((short)0x0008);
        }});
        
        //(RST nn)
        reg_op(new OpCode(0xd7, 1, 0, 16, "RST 10H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.push16((short)(cpu.rpc() + 1));
            cpu.wpc((short)0x0010);
        }});
        
        //(RST nn)
        reg_op(new OpCode(0xdf, 1, 0, 16, "RST 18H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.push16((short)(cpu.rpc() + 1));
            cpu.wpc((short)0x0018);
        }});
        
        //(RST nn)
        reg_op(new OpCode(0xe7, 1, 0, 16, "RST 20H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.push16((short)(cpu.rpc() + 1));
            cpu.wpc((short)0x0020);
        }});
        
        //(RST nn)
        reg_op(new OpCode(0xef, 1, 0, 16, "RST 28H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.push16((short)(cpu.rpc() + 1));
            cpu.wpc((short)0x0028);
        }});
        
        //(RST nn)
        reg_op(new OpCode(0xf7, 1, 0, 16, "RST 30H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.push16((short)(cpu.rpc() + 1));
            cpu.wpc((short)0x0030);
        }});
        
        //(RST nn)
        reg_op(new OpCode(0xff, 1, 0, 16, "RST 38H") {@Override protected void execute0(CPU cpu, Memory mem) {
            cpu.push16((short)(cpu.rpc() + 1));
            cpu.wpc((short)0x0038);
        }});
    }
    
    public OpCode decodeBasicOp(byte code) {
        return base_ops[Bin.toInt(code)];
    }
    
    public OpCode decodePrefixOp(byte code) {
        return prefix_ops[Bin.toInt(code)];
    }
    
    private void reg_op(OpCode op) {
        if(op.isPrefixed())
            prefix_ops[op.code() & 0xFF] = op;
        else
            base_ops[op.code() & 0xFF] = op;
    }
}
