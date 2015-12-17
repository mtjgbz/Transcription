/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import static javax.sound.sampled.LineEvent.Type.STOP;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Noah, Mike, Casey and Erica
 */
public class ToneTable extends javax.swing.JFrame {

    Clip clip;
    int buttonNum = 0;
    int numOfButtons = 121;
    ArrayList<ArrayList<String>> stringNames = new ArrayList<>();
    ArrayList<Integer> count = new ArrayList<>();
    private static String path;

    /**
     * Creates new form ToneTable
     */
    public ToneTable(String path) {
        initComponents();
        this.setTitle("Mixtec Transcription: Tone Table");
        this.setLocation(x, y);
        this.path = path;
        for (int i = 0; i < numOfButtons; i++) {
            count.add(0);
        }
        /**
         * creates the ArrayLists for the ArrayList stringNames and adds them
         */
        ArrayList<String> i0 = new ArrayList<>();//1.1a
        i0.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");
        i0.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");
        stringNames.add(i0);
        ArrayList<String> i1 = new ArrayList<>();//1.1b
        i1.add("b_1-1_ndi71i1_1082_Yolox-RCG500_edited.wav");
        i1.add("b_1-1_ka71a1_0366_Yolox-RCG500_edited.wav");
        stringNames.add(i1);
        ArrayList<String> i2 = new ArrayList<>();//1.1c
        i2.add("c_1-1_i1in1_0018_Yolox-RCG500_edited.wav");
        i2.add("c_1-1_tu1un1_0363_Yolox-RCG500_edited.wav");
        stringNames.add(i2);
        ArrayList<String> i3 = new ArrayList<>();//1.1d
        i3.add("d_1-1_ka71an1_0174_Yolox-RCG500_edited.wav");
        i3.add("d_1-1_si71in1_edited.wav");
        stringNames.add(i3);
        ArrayList<String> i4 = new ArrayList<>();//1.1e
        i4.add("e_1-1_ka1ta1_1080_Yolox-RCG500_edited.wav");
        i4.add("e_1-1_ta1ni1_1301_Yolox-RCG500_edited.wav");
        stringNames.add(i4);
        ArrayList<String> i5 = new ArrayList<>();//1.1f
        i5.add("f_1-1_nda71bi1_0686_Yolox-RCG500_edited.wav");
        i5.add("f_1-1_na71ma1_0072_Yolox-RCG500_edited.wav");
        stringNames.add(i5);
        ArrayList<String> i6 = new ArrayList<>();//1.1g
        i6.add("g_1-1_nda1xin1_1146_Yolox-RCG500_edited.wav");
        i6.add("g_1-1_ta1tan1_1065_Yolox-RCG500_edited.wav");
        stringNames.add(i6);
        ArrayList<String> i7 = new ArrayList<>();//3.3a
        i7.add("a_3-3_ya3a3_0113_Yolox-RCG500_edited.wav");
        i7.add("a_3-3_nda3a3_0327_Yolox-RCG500_edited.wav");
        stringNames.add(i7);
        ArrayList<String> i8 = new ArrayList<>();//3.3b
        i8.add("b_3-3_ndi73i3_0280_Yolox-RCG500_edited.wav");
        i8.add("b_3-3_ka73a3_1826a_Yolox-RCG500_edited.wav");
        stringNames.add(i8);
        ArrayList<String> i9 = new ArrayList<>();//3.3c
        i9.add("c_3-3_i3in3_0001_Yolox-RCG500_edited.wav");
        i9.add("c_3-3_tu3un3_1085_Yolox-RCG500_edited.wav");
        stringNames.add(i9);
        ArrayList<String> i10 = new ArrayList<>();//3.3d
        i10.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        i10.add("d_3-3_ki73in3_0400_Yolox-RCG500_edited.wav");
        stringNames.add(i10);
        ArrayList<String> i11 = new ArrayList<>();//3.3e
        i11.add("e_3-3_ka3ta3_0333_Yolox-RCG500_edited.wav");
        i11.add("e_3-3_ta3ni3_0355_Yolox-RCG500_edited.wav");
        stringNames.add(i11);
        ArrayList<String> i12 = new ArrayList<>();//3.3f
        i12.add("f_3-3_ka73bi3_0347_Yolox-RCG500_edited.wav");
        i12.add("f_3-3_na73ma3_1322_Yolox-RCG500_edited.wav");
        stringNames.add(i12);
        ArrayList<String> i13 = new ArrayList<>();//3.3g
        i13.add("g_3-3_nda3xin3_1154_Yolox-RCG500_edited.wav");
        i13.add("g_3-3_ya3tan3_0330_Yolox-RCG500_edited.wav");
        stringNames.add(i13);
        ArrayList<String> i14 = new ArrayList<>();//4.4a
        i14.add("a_4-4_ya4a4_0489_Yolox-RCG500_edited.wav");
        i14.add("a_4-4_nda4a4_0114_Yolox-RCG500_edited.wav");
        stringNames.add(i14);
        ArrayList<String> i15 = new ArrayList<>();//4.4b
        i15.add("b_4-4_ndi74i4_1673_Yolox-RCG500_edited.wav");
        i15.add("b_4-4_ko74o4_1105_Yolox-RCG500_edited.wav");
        stringNames.add(i15);
        ArrayList<String> i16 = new ArrayList<>();//4.4c
        i16.add("c_4-4_i4in4_0235_Yolox-RCG500_edited.wav");
        i16.add("c_4-4_tiu4un4_1421_Yolox-RCG500_edited.wav");
        stringNames.add(i16);
        ArrayList<String> i17 = new ArrayList<>();//4.4d
        i17.add("d_4-4_ka74an4_edited.wav");
        i17.add("d_4-4_xi74in4_1437_Yolox-RCG500_edited.wav");
        stringNames.add(i17);
        ArrayList<String> i18 = new ArrayList<>();//4.4e
        i18.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        i18.add("e_4-4_tu4mi4_0776_Yolox-RCG500_edited.wav");
        stringNames.add(i18);
        ArrayList<String> i19 = new ArrayList<>();//4.4f
        i19.add("f_4-4_ta74bi4_0666_Yolox-RCG500_edited.wav");
        i19.add("f_4-4_cho74ma4_edited.wav");
        stringNames.add(i10);
        ArrayList<String> i20 = new ArrayList<>();//4.4g
        i20.add("g_4-4_ya4xin4_0623_Yolox-RCG500_edited.wav");
        i20.add("g_4-4_ta4tan4_0604_Yolox-RCG500_edited.wav");
        stringNames.add(i20);
        ArrayList<String> i21 = new ArrayList<>();//4.1b
        i21.add("b_4-1_ta74a1_1347_Yolox-RCG500_edited.wav");
        i21.add("b_4-1_yo74o1_0202_Yolox-RCG500_edited.wav");
        stringNames.add(i21);
        ArrayList<String> i22 = new ArrayList<>();//4.1c
        i22.add("c_1-4_xi1in4_1215_Yolox-RCG500_edited.wav");
        stringNames.add(i22);
        ArrayList<String> i23 = new ArrayList<>();//4.1d
        i23.add("d_4-1_xa74an1_0227_Yolox-RCG500_edited.wav");
        stringNames.add(i23);
        ArrayList<String> i24 = new ArrayList<>();//4.1e
        i24.add("e_4-1_xi4xi1_0556_Yolox-RCG500_edited.wav");
        i24.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i24);
        ArrayList<String> i25 = new ArrayList<>();//4.1f
        i25.add("f_4-1_xa74nu1_0488_Yolox-RCG500_edited.wav");
        stringNames.add(i25);
        ArrayList<String> i26 = new ArrayList<>();//4.1g
        i26.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i26);
        ArrayList<String> i27 = new ArrayList<>();//4.2a
        i27.add("a_4-2_nda4a2_0861_Yolox-RCG500_edited.wav");
        i27.add("a_4-2_kwe4e2_0624_Yolox-RCG500_edited.wav");
        stringNames.add(i27);
        ArrayList<String> i28 = new ArrayList<>();//4.2b
        i28.add("b_4-2_pa74a2_0989_Yolox-RCG500_edited.wav");
        i28.add("b_4-2_tu74u2_0692_Yolox-RCG500_edited.wav");
        stringNames.add(i28);
        ArrayList<String> i29 = new ArrayList<>();//4.2c
        i29.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i29);
        ArrayList<String> i30 = new ArrayList<>();//4.2d
        i30.add("d_4-2_xa74an2_0487_Yolox-RCG500_edited.wav");
        stringNames.add(i30);
        ArrayList<String> i31 = new ArrayList<>();//4.2e
        i31.add("e_4-2_be4xi2_1799_Yolox-RCG500_edited.wav");
        i31.add("e_4-2_sa4ka2_edited.wav");
        stringNames.add(i31);
        ArrayList<String> i32 = new ArrayList<>();//4.2f
        i32.add("f_4-2_nda74bi2_0661_Yolox-RCG500_edited.wav");
        stringNames.add(i32);
        ArrayList<String> i33 = new ArrayList<>();//4.2g
        i33.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i33);
        ArrayList<String> i34 = new ArrayList<>();//4.3b
        i34.add("b_4-3_i74i3_0620_Yolox-RCG500_edited.wav");
        stringNames.add(i34);
        ArrayList<String> i35 = new ArrayList<>();//4.3d
        i35.add("d_4-3_i74in3_0981_Yolox-RCG500_edited.wav");
        stringNames.add(i35);
        ArrayList<String> i36 = new ArrayList<>();//4.3e
        i36.add("e_4-3_xi4xi3_0526_Yolox-RCG500_edited.wav");
        i36.add("e_4-3_bi4ka3_0673_Yolox-RCG500_edited.wav");
        stringNames.add(i36);
        ArrayList<String> i37 = new ArrayList<>();//4.3f
        i37.add("f_4-3_nda74bi3_1385_Yolox-RCG500_edited.wav");
        stringNames.add(i37);
        ArrayList<String> i38 = new ArrayList<>();//4.3g
        i38.add("g_4-3_la4tun3_1083_Yolox-RCG500_edited.wav");
        stringNames.add(i38);
        ArrayList<String> i39 = new ArrayList<>();//3.2a
        i39.add("a_3-2_nda3a2_0653_Yolox-RCG500_edited.wav");
        i39.add("a_3-2_kwe3e2_1257_Yolox-RCG500_edited.wav");
        stringNames.add(i39);
        ArrayList<String> i40 = new ArrayList<>();//3.2b
        i40.add("b_3-2_nda73a2_0538_Yolox-RCG500_edited.wav");
        i40.add("b_3-2_ku73u2_0539_Yolox-RCG500_edited.wav");
        stringNames.add(i40);
        ArrayList<String> i41 = new ArrayList<>();//3.2c
        i41.add("c_3-2_tu3un2_0365_Yolox-RCG500_edited.wav");
        stringNames.add(i41);
        ArrayList<String> i42 = new ArrayList<>();//3.2d
        i42.add("d_3-2_xa73an2_0961_Yolox-RCG500_edited.wav");
        stringNames.add(i42);
        ArrayList<String> i43 = new ArrayList<>();//3.2e
        i43.add("e_3-2_xi3xi2_0126_Yolox-RCG500_edited.wav");
        i43.add("e_3-2_ka3ka2_0812_Yolox-RCG500_edited.wav");
        stringNames.add(i43);
        ArrayList<String> i44 = new ArrayList<>();//3.2f
        i44.add("f_3-2_ka73ndi2_0443_Yolox-RCG500_edited.wav");
        stringNames.add(i44);
        ArrayList<String> i45 = new ArrayList<>();//3.2g
        i45.add("g_3-2_i3tun2_1009_Yolox-RCG500_edited.wav");
        stringNames.add(i45);
        ArrayList<String> i46 = new ArrayList<>();//1.3a
        i46.add("a_1-3_tu1u3_1431_Yolox-RCG500_edited.wav");
        i46.add("a_1-3_sa1a3_edited.wav");
        stringNames.add(i46);
        ArrayList<String> i47 = new ArrayList<>();//1.3b
        i47.add("b_1-3_so71o3_1001_Yolox-RCG500_edited.wav");
        i47.add("b_1-3_kwa71a3_1088_Yolox-RCG500_edited.wav");
        stringNames.add(i47);
        ArrayList<String> i48 = new ArrayList<>();//1.3c
        i48.add("c_1-3_ta1an3_0485_Yolox-RCG500_edited.wav");
        i48.add("c_1-3_ti1in3_0395_Yolox-RCG500_edited.wav");
        stringNames.add(i48);
        ArrayList<String> i49 = new ArrayList<>();//1.3d
        i49.add("d_1-3_si71in3_0195_Yolox-RCG500_edited.wav");
        stringNames.add(i49);
        ArrayList<String> i50 = new ArrayList<>();//1.3e
        i50.add("e_1-3_ke1ta3_1592a_Yolox-RCG500_edited.wav");
        i50.add("e_1-3_ba1xi3_0260_Yolox-RCG500_edited.wav");
        stringNames.add(i50);
        ArrayList<String> i51 = new ArrayList<>();//1.3f
        i51.add("f_1-3_ki71bi3_0450_Yolox-RCG500_edited.wav");
        i51.add("f_1-3_sa71nda3_1176_Yolox-RCG500_edited.wav");
        stringNames.add(i51);
        ArrayList<String> i52 = new ArrayList<>();//1.3g
        i52.add("g_1-3_bi1xin3_0634_Yolox-RCG500_edited.wav");
        i52.add("g_1-3_ya1kan3_1806_Yolox-RCG500_edited.wav");
        stringNames.add(i52);
        ArrayList<String> i53 = new ArrayList<>();//1.4a
        i53.add("a_1-4_yu1u4_0251_Yolox-RCG500_edited.wav");
        i53.add("a_1-4_sa1a4_0382_Yolox-RCG500_edited.wav");
        stringNames.add(i53);
        ArrayList<String> i54 = new ArrayList<>();//1.4b
        i54.add("b_1-4_yo71o4_0493_Yolox-RCG500_edited.wav");
        i54.add("b_1-4_kwa71a4_edited.wav");
        stringNames.add(i54);
        ArrayList<String> i55 = new ArrayList<>();//1.4c
        i55.add("c_1-4_ja1an4_edited.wav");
        i55.add("c_1-4_xi1in4_1215_Yolox-RCG500_edited.wav");
        stringNames.add(i55);
        ArrayList<String> i56 = new ArrayList<>();//1.4d
        i56.add("d_1-4_ti71in4_0744_Yolox-RCG500_edited.wav");
        stringNames.add(i56);
        ArrayList<String> i57 = new ArrayList<>();//1.4e
        i57.add("e_1-4_sa1ta4_0186_Yolox-RCG500_edited.wav");
        i57.add("e_1-4_ta1xi4_0392_Yolox-RCG500_edited.wav");
        stringNames.add(i57);
        ArrayList<String> i58 = new ArrayList<>();//1.4f
        i58.add("f_1-4_ta71bi4_0390_Yolox-RCG500_edited.wav");
        i58.add("f_1-4_xa71nda4_0969_Yolox-RCG500_edited.wav");
        stringNames.add(i58);
        ArrayList<String> i59 = new ArrayList<>();//1.4g
        i59.add("g_1-4_xi1xin4_1251_Yolox-RCG500_edited.wav");
        i59.add("g_1-4_ka1xan4_0387_Yolox-RCG500_edited.wav");
        stringNames.add(i59);
        ArrayList<String> i60 = new ArrayList<>();//3.4a
        i60.add("a_3-4_tu3u4_0513_Yolox-RCG500_edited.wav");
        i60.add("a_3-4_sa3a4_0912_Yolox-RCG500_edited.wav");
        stringNames.add(i60);
        ArrayList<String> i61 = new ArrayList<>();//3.4b
        i61.add("b_3-4_yo73o4_0247_Yolox-RCG500_edited.wav");
        i61.add("b_3-4_ka73a4_0787_Yolox-RCG500_edited.wav");
        stringNames.add(i61);
        ArrayList<String> i62 = new ArrayList<>();//3.4c
        i62.add("c_3-4_ta3an4_0319_Yolox-RCG500_edited.wav");
        i62.add("c_3-4_xi3in4_1258_Yolox-RCG500_edited.wav");
        stringNames.add(i62);
        ArrayList<String> i63 = new ArrayList<>();//3.4d
        i63.add("d_3-4_ka73an4_0412_Yolox-RCG500_edited.wav");
        stringNames.add(i63);
        ArrayList<String> i64 = new ArrayList<>();//3.4e
        i64.add("e_3-4_sa3ta4_0516_Yolox-RCG500_edited.wav");
        i64.add("e_3-4_ta3xi4_0393_Yolox-RCG500_edited.wav");
        stringNames.add(i64);
        ArrayList<String> i65 = new ArrayList<>();//3.4f
        i65.add("f_3-4_ta73bi4_0391_Yolox-RCG500_edited.wav");
        i65.add("f_3-4_ka73nda4_1734_Yolox-RCG500_edited.wav");
        stringNames.add(i65);
        ArrayList<String> i66 = new ArrayList<>();//3.4g
        i66.add("g_3-4_ki3xin4_1012_Yolox-RCG500_edited.wav");
        i66.add("g_3-4_ka3xan4_0092_Yolox-RCG500_edited.wav");
        stringNames.add(i66);
        ArrayList<String> i67 = new ArrayList<>();//13.2d
        i67.add("d_13-2_ti713in2_1907_Yolox-RCG500_edited.wav");
        stringNames.add(i67);
        ArrayList<String> i68 = new ArrayList<>();//13.2e
        i68.add("e_13-2_su13nda2_1202_Yolox-RCG500_edited.wav");
        stringNames.add(i68);
        ArrayList<String> i69 = new ArrayList<>();//13.2f
        i69.add("f_13-2_ti713bi2_0944_Yolox-RCG500_edited.wav");
        stringNames.add(i69);
        ArrayList<String> i70 = new ArrayList<>();//13.3e
        i70.add("e_13-3_xu13xa3_1206_Yolox-RCG500_edited.wav");
        stringNames.add(i70);
        ArrayList<String> i71 = new ArrayList<>();//13.4e
        i71.add("e_13-4_ti13bi4_1911_Yolox-RCG500_edited.wav");
        stringNames.add(i71);
        ArrayList<String> i72 = new ArrayList<>();//13.4g
        i72.add("g_13-4_Ndwa13xin4_2028_Yolox-RCG500_edited.wav");
        stringNames.add(i72);
        ArrayList<String> i73 = new ArrayList<>();//14.1b
        i73.add("b_14-1_na714a1_1320_Yolox-RCG500_edited.wav");
        stringNames.add(i73);
        ArrayList<String> i74 = new ArrayList<>();//14.1f
        i74.add("f_14-1_chu714ma1_1342_Yolox-RCG500_edited.wav");
        stringNames.add(i74);
        ArrayList<String> i75 = new ArrayList<>();//14.2a
        i75.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        i75.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i75);
        ArrayList<String> i76 = new ArrayList<>();//14.2b
        i76.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        i76.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i76);
        ArrayList<String> i77 = new ArrayList<>();//14.2d
        i77.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i77);
        ArrayList<String> i78 = new ArrayList<>();//14.2e
        i78.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i78);
        ArrayList<String> i79 = new ArrayList<>();//14.2f
        i79.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i79);
        ArrayList<String> i80 = new ArrayList<>();//14.2g
        i80.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i80);
        ArrayList<String> i81 = new ArrayList<>();//14.3a
        i81.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        i81.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i81);
        ArrayList<String> i82 = new ArrayList<>();//14.3c
        i82.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i82);
        ArrayList<String> i83 = new ArrayList<>();//14.3e
        i83.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i83);
        ArrayList<String> i84 = new ArrayList<>();//14.3f
        i84.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i84);
        ArrayList<String> i85 = new ArrayList<>();//14.3g
        i85.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i85);
        ArrayList<String> i86 = new ArrayList<>();//14.4b
        i86.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        i86.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i86);
        ArrayList<String> i87 = new ArrayList<>();//14.4d
        i87.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i87);
        ArrayList<String> i88 = new ArrayList<>();//14.4e
        i88.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        i88.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i88);
        ArrayList<String> i89 = new ArrayList<>();//14.4g
        i89.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i89);
        ArrayList<String> i90 = new ArrayList<>();//1.42e
        i90.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i90);
        ArrayList<String> i91 = new ArrayList<>();//1.42f
        i91.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i91);
        ArrayList<String> i92 = new ArrayList<>();//1.42g
        i92.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i92);
        ArrayList<String> i93 = new ArrayList<>();//1.43e
        i93.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i93);
        ArrayList<String> i94 = new ArrayList<>();//1.32a
        i94.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i94);
        ArrayList<String> i95 = new ArrayList<>();//1.32e
        i95.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i95);
        ArrayList<String> i96 = new ArrayList<>();//1.32f
        i96.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i96);
        ArrayList<String> i97 = new ArrayList<>();//3.42a
        i97.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i97);
        ArrayList<String> i98 = new ArrayList<>();//3.42b
        i98.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i98);
        ArrayList<String> i99 = new ArrayList<>();//3.42e
        i99.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i99);
        ArrayList<String> i100 = new ArrayList<>();//3.42g
        i100.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i100);
        ArrayList<String> i101 = new ArrayList<>();//4.42e
        i101.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i101);
        ArrayList<String> i102 = new ArrayList<>();//4.13a
        i102.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i102);
        ArrayList<String> i103 = new ArrayList<>();//4.13b
        i103.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i103);
        ArrayList<String> i104 = new ArrayList<>();//4.13d
        i104.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i104);
        ArrayList<String> i105 = new ArrayList<>();//4.13e
        i105.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i105);
        ArrayList<String> i106 = new ArrayList<>();//4.13f
        i106.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i106);
        ArrayList<String> i107 = new ArrayList<>();//4.13g
        i107.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i107);
        ArrayList<String> i108 = new ArrayList<>();//4.14e
        i108.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i108);
        ArrayList<String> i109 = new ArrayList<>();//4.14f
        i109.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i109);
        ArrayList<String> i110 = new ArrayList<>();//4.24a
        i110.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i110);
        ArrayList<String> i111 = new ArrayList<>();//4.24c
        i111.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        i111.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i111);
        ArrayList<String> i112 = new ArrayList<>();//4.24e
        i112.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i112);
        ArrayList<String> i113 = new ArrayList<>();//4.24f
        i113.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i113);
        ArrayList<String> i114 = new ArrayList<>();//4.24g
        i114.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i114);
        ArrayList<String> i115 = new ArrayList<>();//3.13f
        i115.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i115);
        ArrayList<String> i116 = new ArrayList<>();//3.14e
        i116.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i116);
        ArrayList<String> i117 = new ArrayList<>();//4.34e
        i117.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i117);
        ArrayList<String> i118 = new ArrayList<>();//143a
        i118.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        i118.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        i118.add("a_1-1_nda1a1_1024_Yolox-RCG500_edited.wav");//need
        stringNames.add(i118);
        ArrayList<String> i119 = new ArrayList<>();//132a
        i119.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i119);
        ArrayList<String> i120 = new ArrayList<>();//342a
        i120.add("a_1-1_ya1a1_0945_Yolox-RCG500_edited.wav");//need
        stringNames.add(i120);
    }

    /**
     * method that creates the audio clip every time the button is clicked to
     * avoid heap space errors
     */
    public void buttonAction() {
        AudioInputStream audioIn = null;
        try {
            if (clip == null || !clip.isOpen()) {
                audioIn = AudioSystem.getAudioInputStream(new File(path + stringNames.get(buttonNum).get(count.get(buttonNum))));
                clip = AudioSystem.getClip();
                clip.open(audioIn);
                audioIn.close();
                clip.addLineListener(listener);
                clip.start();
            } else {
                clip.stop();

                audioIn = AudioSystem.getAudioInputStream(new File(path + stringNames.get(buttonNum).get(count.get(buttonNum))));
                clip = AudioSystem.getClip();
                clip.open(audioIn);
                audioIn.close();
                clip.addLineListener(listener);
                clip.start();
            }

        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(ToneTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ToneTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(ToneTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (count.get(buttonNum).equals(stringNames.get(buttonNum).size() - 1)) {
            count.set(buttonNum, 0);
        } else {
            int value = count.get(buttonNum);
            value = value + 1;
            count.set(buttonNum, value);
        }
    }
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
    Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();

    int x = 0;
    int y = 0;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jButton57 = new javax.swing.JButton();
        jScrollBar1 = new javax.swing.JScrollBar();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        jButton65 = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        jButton67 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton57real = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton68 = new javax.swing.JButton();
        jButton69 = new javax.swing.JButton();
        jButton70 = new javax.swing.JButton();
        jButton71 = new javax.swing.JButton();
        jButton72 = new javax.swing.JButton();
        jButton73 = new javax.swing.JButton();
        jButton74 = new javax.swing.JButton();
        jButton75 = new javax.swing.JButton();
        jButton76 = new javax.swing.JButton();
        jButton77 = new javax.swing.JButton();
        jButton78 = new javax.swing.JButton();
        jButton79 = new javax.swing.JButton();
        jButton80 = new javax.swing.JButton();
        jButton81 = new javax.swing.JButton();
        jButton82 = new javax.swing.JButton();
        jButton83 = new javax.swing.JButton();
        jButton84 = new javax.swing.JButton();
        jButton85 = new javax.swing.JButton();
        jButton86 = new javax.swing.JButton();
        jButton87 = new javax.swing.JButton();
        jButton88 = new javax.swing.JButton();
        jButton89 = new javax.swing.JButton();
        jButton90 = new javax.swing.JButton();
        jButton91 = new javax.swing.JButton();
        jButton92 = new javax.swing.JButton();
        jButton93 = new javax.swing.JButton();
        jButton94 = new javax.swing.JButton();
        jButton95 = new javax.swing.JButton();
        jButton96 = new javax.swing.JButton();
        jButton97 = new javax.swing.JButton();
        jButton98 = new javax.swing.JButton();
        jButton99 = new javax.swing.JButton();
        jButton100 = new javax.swing.JButton();
        jButton101 = new javax.swing.JButton();
        jButton102 = new javax.swing.JButton();
        jButton103 = new javax.swing.JButton();
        jButton104 = new javax.swing.JButton();
        jButton105 = new javax.swing.JButton();
        jButton106 = new javax.swing.JButton();
        jButton107 = new javax.swing.JButton();
        jButton108 = new javax.swing.JButton();
        jButton109 = new javax.swing.JButton();
        jButton110 = new javax.swing.JButton();
        jButton111 = new javax.swing.JButton();
        jButton112 = new javax.swing.JButton();
        jButton113 = new javax.swing.JButton();
        jButton114 = new javax.swing.JButton();
        jButton115 = new javax.swing.JButton();
        jButton116 = new javax.swing.JButton();
        jButton117 = new javax.swing.JButton();
        jButton118 = new javax.swing.JButton();
        jButton119 = new javax.swing.JButton();
        jButton120 = new javax.swing.JButton();
        jButton121 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jButton57.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton57.setText("<html><center><font color=\"orange\">ka<sup>4</sup>ta<sup>4</sup></font><br>tu<sup>4</sup>mi<sup>4</sup><br><font size=\"1\"> (48)</font></center></html>\\n");
        jButton57.setMaximumSize(new java.awt.Dimension(80, 52));
        jButton57.setMinimumSize(new java.awt.Dimension(80, 52));
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });

        setResizable(false);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane1.setHorizontalScrollBar(null);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton3.setText("<html><center><font color=\"orange\">i<sup>1</sup>in<sup>1</sup></font><br>tu<sup>1</sup>un<sup>1</sup><br><font size=\"1\"> (4)</font></center></html>\\n");
        jButton3.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton3.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton3.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton4.setText("<html><center><font color=\"orange\">ka'<sup>1</sup>an<sup>1</sup></font><br>si'<sup>1</sup>in<sup>1</sup><br><font size=\"1\"> (7)</font></center></html>\\n");
        jButton4.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton4.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton4.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton5.setText("<html><center><font color=\"orange\">ka<sup>1</sup>ta<sup>1</sup></font><br>ta<sup>1</sup>ni<sup>1</sup><br><font size=\"1\"> (65)</font></center></html>\\n");
        jButton5.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton5.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton5.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton6.setText("<html><center><font color=\"orange\">nda'<sup>1</sup>bi<sup>1</sup></font><br>na'<sup>1</sup>ma<sup>1</sup><br><font size=\"1\"> (26)</font></center></html>\\n");
        jButton6.setMaximumSize(new java.awt.Dimension(95, 52));
        jButton6.setMinimumSize(new java.awt.Dimension(95, 52));
        jButton6.setPreferredSize(new java.awt.Dimension(95, 52));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton7.setText("<html><center><font color=\"orange\">nda<sup>1</sup>xin<sup>1</sup></font><br>ta<sup>1</sup>tan<sup>1</sup><br><font size=\"1\"> (20)</font></center></html>\\n");
        jButton7.setMaximumSize(new java.awt.Dimension(95, 52));
        jButton7.setMinimumSize(new java.awt.Dimension(95, 52));
        jButton7.setPreferredSize(new java.awt.Dimension(95, 52));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton2.setText("<html><center><font color=\"orange\">ndi'<sup>1</sup>i<sup>1</sup></font><br>ka'<sup>1</sup>a<sup>1</sup><br><font size=\"1\"> (16)</font></center></html>\\n");
        jButton2.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton2.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton2.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton1.setText("<html><center><font color=\"orange\">ya<sup>1</sup>a<sup>1</sup></font><br>nda<sup>1</sup>a<sup>1</sup><br><font size=\"1\"> (5)</font></center></html>\\n");
        jButton1.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton1.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton1.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton10.setText("<html><center><font color=\"orange\">i<sup>3</sup>in<sup>3</sup></font><br>tu<sup>3</sup>un<sup>3</sup><br><font size=\"1\"> (7)</font></center></html>\\n");
        jButton10.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton10.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton10.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton11.setText("<html><center><font color=\"orange\">ka'<sup>3</sup>an<sup>3</sup></font><br>ki'<sup>3</sup>in<sup>3</sup><br><font size=\"1\"> (6)</font></center></html>\\n");
        jButton11.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton11.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton11.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton12.setText("<html><center><font color=\"orange\">ka<sup>3</sup>ta<sup>3</sup></font><br>ta<sup>3</sup>ni<sup>3</sup><br><font size=\"1\"> (99)</font></center></html>\\n");
        jButton12.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton12.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton12.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton9.setText("<html><center><font color=\"orange\">ndi'<sup>3</sup>i<sup>3</sup></font><br>ka'<sup>3</sup>a<sup>3</sup><br><font size=\"1\"> (12)</font></center></html>\\n");
        jButton9.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton9.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton9.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton8.setText("<html><center><font color=\"orange\">ya<sup>3</sup>a<sup>3</sup></font><br>nda<sup>3</sup>a<sup>3</sup><br><font size=\"1\"> (22)</font></center></html>\\n");
        jButton8.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton8.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton8.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton13.setText("<html><center><font color=\"orange\">ka'<sup>3</sup>bi<sup>3</sup></font><br>na'<sup>3</sup>ma<sup>3</sup><br><font size=\"1\"> (20)</font></center></html>\\n");
        jButton13.setMaximumSize(new java.awt.Dimension(95, 52));
        jButton13.setMinimumSize(new java.awt.Dimension(95, 52));
        jButton13.setPreferredSize(new java.awt.Dimension(95, 52));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton14.setText("<html><center><font color=\"orange\">nda<sup>3</sup>xin<sup>3</sup></font><br>ya<sup>3</sup>tan<sup>3</sup><br><font size=\"1\"> (8)</font></center></html>\\n");
        jButton14.setMaximumSize(new java.awt.Dimension(95, 52));
        jButton14.setMinimumSize(new java.awt.Dimension(95, 52));
        jButton14.setPreferredSize(new java.awt.Dimension(95, 52));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(255, 255, 255));
        jButton21.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton21.setText("<html><center><font color=\"orange\">ya<sup>4</sup>xin<sup>4</sup></font><br>ta<sup>4</sup>tan<sup>4</sup><br><font size=\"1\"> (8)</font></center></html>\\n");
        jButton21.setMaximumSize(new java.awt.Dimension(95, 52));
        jButton21.setMinimumSize(new java.awt.Dimension(95, 52));
        jButton21.setPreferredSize(new java.awt.Dimension(95, 52));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(255, 255, 255));
        jButton16.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton16.setText("<html><center><font color=\"orange\">ndi'<sup>4</sup>i<sup>4</sup></font><br>ko'<sup>4</sup>o<sup>4</sup><br><font size=\"1\"> (12)</font></center></html>\\n");
        jButton16.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton16.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton16.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(255, 255, 255));
        jButton15.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton15.setText("<html><center><font color=\"orange\">ya<sup>4</sup>a<sup>4</sup></font><br>nda<sup>4</sup>a<sup>4</sup><br><font size=\"1\"> (19)</font></center></html>\\n");
        jButton15.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton15.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton15.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton17.setBackground(new java.awt.Color(255, 255, 255));
        jButton17.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton17.setText("<html><center><font color=\"orange\">i<sup>4</sup>in<sup>4</sup></font><br>tiu<sup>4</sup>un<sup>4</sup><br><font size=\"1\"> (7)</font></center></html>\\n");
        jButton17.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton17.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton17.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(255, 255, 255));
        jButton18.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton18.setText("<html><center><font color=\"orange\">ka'<sup>4</sup>an<sup>4</sup></font><br>xi'<sup>4</sup>in<sup>4</sup><br><font size=\"1\"> (9)</font></center></html>\\n");
        jButton18.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton18.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton18.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(255, 255, 255));
        jButton19.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton19.setText("<html><center><font color=\"orange\">ka<sup>4</sup>ta<sup>4</sup></font><br>tu<sup>4</sup>mi<sup>4</sup><br><font size=\"1\"> (48)</font></center></html>\\n");
        jButton19.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton19.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton19.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setBackground(new java.awt.Color(255, 255, 255));
        jButton20.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton20.setText("<html><center><font color=\"orange\">ta'<sup>4</sup>bi<sup>4</sup></font><br>cho'<sup>4</sup>ma<sup>4</sup><br><font size=\"1\"> (10)</font></center></html>\\n");
        jButton20.setMaximumSize(new java.awt.Dimension(95, 52));
        jButton20.setMinimumSize(new java.awt.Dimension(95, 52));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton27.setBackground(new java.awt.Color(255, 255, 255));
        jButton27.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton27.setText("<html><center><font color=\"orange\">xi<sup>4</sup>tun<sup>1</sup></font><br><font size=\"1\"> (6)</font></center></html>\\n");
        jButton27.setMaximumSize(new java.awt.Dimension(95, 52));
        jButton27.setMinimumSize(new java.awt.Dimension(95, 52));
        jButton27.setPreferredSize(new java.awt.Dimension(95, 52));
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton22.setBackground(new java.awt.Color(255, 255, 255));
        jButton22.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton22.setText("<html><center><font color=\"orange\">ta'<sup>4</sup>a<sup>1</sup></font><br>yo'<sup>4</sup>o<sup>1</sup><br><font size=\"1\"> (9)</font></center></html>\\n");
        jButton22.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton22.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton22.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(255, 255, 255));
        jButton23.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton23.setText("<html><center><font color=\"orange\">xi<sup>4</sup>in<sup>1</sup></font><br><font size=\"1\"> (1)</font></center></html>\\n");
        jButton23.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton23.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton23.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setBackground(new java.awt.Color(255, 255, 255));
        jButton24.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton24.setText("<html><center><font color=\"orange\">xa'<sup>4</sup>an<sup>1</sup></font><br><font size=\"1\"> (3)</font></center></html>\\n");
        jButton24.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton24.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton24.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(255, 255, 255));
        jButton26.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton26.setText("<html><center><font color=\"orange\">xa'<sup>4</sup>nu<sup>1</sup></font><br><font size=\"1\"> (7)</font></center></html>\\n");
        jButton26.setMaximumSize(new java.awt.Dimension(95, 52));
        jButton26.setMinimumSize(new java.awt.Dimension(95, 52));
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton34.setBackground(new java.awt.Color(255, 255, 255));
        jButton34.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton34.setText("<html><center><font color=\"orange\">ndi<sup>4</sup>tun<sup>2</sup></font><br><font size=\"1\"> (4)</font></center></html>\\n");
        jButton34.setMaximumSize(new java.awt.Dimension(95, 52));
        jButton34.setMinimumSize(new java.awt.Dimension(95, 52));
        jButton34.setPreferredSize(new java.awt.Dimension(95, 52));
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton29.setBackground(new java.awt.Color(255, 255, 255));
        jButton29.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton29.setText("<html><center><font color=\"orange\">pa'<sup>4</sup>a<sup>2</sup></font><br>tu'<sup>4</sup>u<sup>2</sup><br><font size=\"1\"> (9)</font></center></html>\\n");
        jButton29.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton29.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton29.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setBackground(new java.awt.Color(255, 255, 255));
        jButton30.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton30.setText("<html><center><font color=\"orange\">xi<sup>4</sup>in<sup>2</sup></font><br><font size=\"1\"> (3)</font></center></html>\\n");
        jButton30.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton30.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton30.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setBackground(new java.awt.Color(255, 255, 255));
        jButton31.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton31.setText("<html><center><font color=\"orange\">xa'<sup>4</sup>an<sup>2</sup></font><br><font size=\"1\"> (2)</font></center></html>\\n");
        jButton31.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton31.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton31.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton33.setBackground(new java.awt.Color(255, 255, 255));
        jButton33.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton33.setText("<html><center><font color=\"orange\">nda'<sup>4</sup>bi<sup>2</sup></font><br><font size=\"1\"> (4)</font></center></html>\\n");
        jButton33.setMaximumSize(new java.awt.Dimension(95, 52));
        jButton33.setMinimumSize(new java.awt.Dimension(95, 52));
        jButton33.setPreferredSize(new java.awt.Dimension(95, 52));
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton28.setBackground(new java.awt.Color(255, 255, 255));
        jButton28.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton28.setText("<html><center><font color=\"orange\">nda<sup>4</sup>a<sup>2</sup></font><br>kwe<sup>4</sup>e<sup>2</sup><br><font size=\"1\"> (7)</font></center></html>\\n");
        jButton28.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton28.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton28.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton39.setBackground(new java.awt.Color(255, 255, 255));
        jButton39.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton39.setText("<html><center><font color=\"orange\">la<sup>4</sup>tun<sup>3</sup></font><br><font size=\"1\"> (5)</font></center></html>\\n");
        jButton39.setMaximumSize(new java.awt.Dimension(95, 52));
        jButton39.setMinimumSize(new java.awt.Dimension(95, 52));
        jButton39.setPreferredSize(new java.awt.Dimension(95, 52));
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jButton35.setBackground(new java.awt.Color(255, 255, 255));
        jButton35.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton35.setText("<html><center>i'<sup>4</sup>i<sup>3</sup><br><font size=\"1\"> (1)</font></center></html>\\n");
        jButton35.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton35.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton35.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton36.setBackground(new java.awt.Color(255, 255, 255));
        jButton36.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton36.setText("<html><center><font color=\"orange\">i'<sup>4</sup>in<sup>3</sup></font><br><font size=\"1\"> (1)</font></center></html>\\n");
        jButton36.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton36.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton36.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jButton38.setBackground(new java.awt.Color(255, 255, 255));
        jButton38.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton38.setText("<html><center><font color=\"orange\">nda'<sup>4</sup>bi<sup>3</sup></font><br><font size=\"1\"> (12)</font></center></html>\\n");
        jButton38.setMaximumSize(new java.awt.Dimension(95, 52));
        jButton38.setMinimumSize(new java.awt.Dimension(95, 52));
        jButton38.setPreferredSize(new java.awt.Dimension(95, 52));
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton46.setBackground(new java.awt.Color(255, 255, 255));
        jButton46.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton46.setText("<html><center><font color=\"orange\">i<sup>3</sup>tun<sup>2</sup></font><br><font size=\"1\"> (11)</font></center></html>\\n");
        jButton46.setMaximumSize(new java.awt.Dimension(95, 52));
        jButton46.setMinimumSize(new java.awt.Dimension(95, 52));
        jButton46.setPreferredSize(new java.awt.Dimension(95, 52));
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        jButton41.setBackground(new java.awt.Color(255, 255, 255));
        jButton41.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton41.setText("<html><center><font color=\"orange\">nda'<sup>3</sup>a<sup>2</sup></font><br>ku'<sup>3</sup>u<sup>2</sup></center></html>\\n");
        jButton41.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton41.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton41.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jButton42.setBackground(new java.awt.Color(255, 255, 255));
        jButton42.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton42.setText("<html><center><font color=\"orange\">tu<sup>3</sup>un<sup>2</sup></font><br><font size=\"1\"> (2)</font></center></html>\\n");
        jButton42.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton42.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton42.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jButton43.setBackground(new java.awt.Color(255, 255, 255));
        jButton43.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton43.setText("<html><center><font color=\"orange\">xa'<sup>3</sup>an<sup>2</sup></font><br><font size=\"1\"> (3)</font></center></html>\\n");
        jButton43.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton43.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton43.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jButton45.setBackground(new java.awt.Color(255, 255, 255));
        jButton45.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton45.setText("<html><center><font color=\"orange\">ka'<sup>3</sup>ndi<sup>2</sup></font><br><font size=\"1\"> (9)</font></center></html>\\n");
        jButton45.setMaximumSize(new java.awt.Dimension(95, 52));
        jButton45.setMinimumSize(new java.awt.Dimension(95, 52));
        jButton45.setPreferredSize(new java.awt.Dimension(95, 52));
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        jButton40.setBackground(new java.awt.Color(255, 255, 255));
        jButton40.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton40.setText("<html><center><font color=\"orange\">nda<sup>3</sup>a<sup>2</sup></font><br>kwe<sup>3</sup>e<sup>2</sup><br><font size=\"1\"> (14)</font></center></html>\\n");
        jButton40.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton40.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton40.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jButton25.setBackground(new java.awt.Color(255, 255, 255));
        jButton25.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton25.setText("<html><center><font color=\"orange\">xi<sup>4</sup>xi<sup>1</sup></font><br>sa<sup>4</sup>ka<sup>1</sup><br><font size=\"1\"> (26)</font></center></html>\\n");
        jButton25.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton25.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton25.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton32.setBackground(new java.awt.Color(255, 255, 255));
        jButton32.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton32.setText("<html><center><font color=\"orange\">be<sup>4</sup>xi<sup>2</sup></font><br>sa<sup>4</sup>ka<sup>2</sup><br><font size=\"1\"> (56)</font></center></html>\\n");
        jButton32.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton32.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton32.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton37.setBackground(new java.awt.Color(255, 255, 255));
        jButton37.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton37.setText("<html><center><font color=\"orange\">xi<sup>4</sup>xi<sup>3</sup></font><br>bi<sup>4</sup>ka<sup>3</sup><br><font size=\"1\"> (42)</font></center></html>\\n");
        jButton37.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton37.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton37.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jButton44.setBackground(new java.awt.Color(255, 255, 255));
        jButton44.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton44.setText("<html><center><font color=\"orange\">xi<sup>3</sup>xi<sup>2</sup></font><br>ka<sup>3</sup>ka<sup>2</sup><br><font size=\"1\"> (67)</font></center></html>\\n");
        jButton44.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton44.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton44.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jButton47.setBackground(new java.awt.Color(255, 255, 255));
        jButton47.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton47.setText("<html><center><font color=\"orange\">tu<sup>1</sup>u<sup>3</sup></font><br>sa<sup>1</sup>a<sup>3</sup><br><font size=\"1\"> (21)</font></center></html>\\n");
        jButton47.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton47.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton47.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jButton48.setBackground(new java.awt.Color(255, 255, 255));
        jButton48.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton48.setText("<html><center><font color=\"orange\">so'<sup>1</sup>o<sup>3</sup></font><br>kwa'<sup>1</sup>a<sup>3</sup><br><font size=\"1\"> (16)</font></center></html>\\n");
        jButton48.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton48.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        jButton55.setBackground(new java.awt.Color(255, 255, 255));
        jButton55.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton55.setText("<html><center><font color=\"orange\">yo'<sup>1</sup>o<sup>4</sup></font><br>kwa'<sup>1</sup>a<sup>4</sup><br><font size=\"1\"> (15)</font></center></html>\\n");
        jButton55.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton55.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });

        jButton54.setBackground(new java.awt.Color(255, 255, 255));
        jButton54.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton54.setText("<html><center><font color=\"orange\">yu<sup>1</sup>u<sup>4</sup></font><br>sa<sup>1</sup>a<sup>4</sup><br><font size=\"1\"> (21)</font></center></html>\\n");
        jButton54.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton54.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton54.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });

        jButton61.setBackground(new java.awt.Color(255, 255, 255));
        jButton61.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton61.setText("<html><center><font color=\"orange\">tu<sup>3</sup>u<sup>4</sup></font><br>sa<sup>3</sup>a<sup>4</sup><br><font size=\"1\"> (15)</font></center></html>\\n");
        jButton61.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton61.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton61.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });

        jButton62.setBackground(new java.awt.Color(255, 255, 255));
        jButton62.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton62.setText("<html><center><font color=\"orange\">yo'<sup>3</sup>o<sup>4</sup></font><br>ka'<sup>3</sup>a<sup>4</sup><br><font size=\"1\"> (16)</font></center></html>\\n");
        jButton62.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton62.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton62.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton62ActionPerformed(evt);
            }
        });

        jButton63.setBackground(new java.awt.Color(255, 255, 255));
        jButton63.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton63.setText("<html><center><font color=\"orange\">ta<sup>3</sup>an<sup>4</sup></font><br>xi<sup>3</sup>in<sup>4</sup><br><font size=\"1\"> (9)</font></center></html>\\n");
        jButton63.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton63.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton63.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton63ActionPerformed(evt);
            }
        });

        jButton64.setBackground(new java.awt.Color(255, 255, 255));
        jButton64.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton64.setText("<html><center><font color=\"orange\">ka'<sup>3</sup>an<sup>4</sup></font><br><font size=\"1\"> (1)</font></center></html>\\n");
        jButton64.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton64.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton64.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton64ActionPerformed(evt);
            }
        });

        jButton65.setBackground(new java.awt.Color(255, 255, 255));
        jButton65.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton65.setText("<html><center><font color=\"orange\">sa<sup>3</sup>ta<sup>4</sup></font><br>ta<sup>3</sup>xi<sup>4</sup><br><font size=\"1\"> (85)</font></center></html>\\n");
        jButton65.setMaximumSize(new java.awt.Dimension(85, 52));
        jButton65.setMinimumSize(new java.awt.Dimension(85, 52));
        jButton65.setPreferredSize(new java.awt.Dimension(85, 52));
        jButton65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton65ActionPerformed(evt);
            }
        });

        jButton66.setBackground(new java.awt.Color(255, 255, 255));
        jButton66.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton66.setText("<html><center><font color=\"orange\">ta'<sup>3</sup>bi<sup>4</sup></font><br>ka'<sup>3</sup>nda<sup>4</sup><br><font size=\"1\"> (19)</font></center></html>\\n");
        jButton66.setMaximumSize(new java.awt.Dimension(95, 52));
        jButton66.setMinimumSize(new java.awt.Dimension(95, 52));
        jButton66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton66ActionPerformed(evt);
            }
        });

        jButton67.setBackground(new java.awt.Color(255, 255, 255));
        jButton67.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton67.setText("<html><center><font color=\"orange\">ki<sup>3</sup>xin<sup>4</sup></font><br>ka<sup>3</sup>xan<sup>4</sup><br><font size=\"1\"> (16)</font></center></html>\\");
            jButton67.setMaximumSize(new java.awt.Dimension(95, 52));
            jButton67.setMinimumSize(new java.awt.Dimension(95, 52));
            jButton67.setPreferredSize(new java.awt.Dimension(95, 52));
            jButton67.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton67ActionPerformed(evt);
                }
            });

            jButton60.setBackground(new java.awt.Color(255, 255, 255));
            jButton60.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
            jButton60.setText("<html><center><font color=\"orange\">xi<sup>1</sup>xin<sup>4</sup></font><br>ka<sup>1</sup>xan<sup>4</sup><br><font size=\"1\"> (17)</font></center></html>\\n");
            jButton60.setMaximumSize(new java.awt.Dimension(95, 52));
            jButton60.setMinimumSize(new java.awt.Dimension(95, 52));
            jButton60.setPreferredSize(new java.awt.Dimension(95, 52));
            jButton60.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton60ActionPerformed(evt);
                }
            });

            jButton53.setBackground(new java.awt.Color(255, 255, 255));
            jButton53.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
            jButton53.setText("<html><center><font color=\"orange\">bi<sup>1</sup>xin<sup>3</sup></font><br>ya<sup>1</sup>kan<sup>3</sup><br><font size=\"1\"> (6)</font></center></html>\\n");
            jButton53.setMaximumSize(new java.awt.Dimension(95, 52));
            jButton53.setMinimumSize(new java.awt.Dimension(95, 52));
            jButton53.setPreferredSize(new java.awt.Dimension(95, 52));
            jButton53.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton53ActionPerformed(evt);
                }
            });

            jButton52.setBackground(new java.awt.Color(255, 255, 255));
            jButton52.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
            jButton52.setText("<html><center><font color=\"orange\">ki'<sup>1</sup>bi<sup>3</sup></font><br>sa'<sup>1</sup>nda<sup>3</sup><br><font size=\"1\"> (10)</font></center></html>\\n");
            jButton52.setMaximumSize(new java.awt.Dimension(95, 52));
            jButton52.setMinimumSize(new java.awt.Dimension(95, 52));
            jButton52.setPreferredSize(new java.awt.Dimension(95, 52));
            jButton52.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton52ActionPerformed(evt);
                }
            });

            jButton59.setBackground(new java.awt.Color(255, 255, 255));
            jButton59.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
            jButton59.setText("<html><center><font color=\"orange\">ta'<sup>1</sup>bi<sup>4</sup></font><br>xa'<sup>1</sup>nda<sup>4</sup><br><font size=\"1\"> (17)</font></center></html>\\n");
            jButton59.setMaximumSize(new java.awt.Dimension(95, 52));
            jButton59.setMinimumSize(new java.awt.Dimension(95, 52));
            jButton59.setPreferredSize(new java.awt.Dimension(95, 52));
            jButton59.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton59ActionPerformed(evt);
                }
            });

            jButton51.setBackground(new java.awt.Color(255, 255, 255));
            jButton51.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
            jButton51.setText("<html><center><font color=\"orange\">ke<sup>1</sup>ta<sup>3</sup></font><br>ba<sup>1</sup>xi<sup>3</sup><br><font size=\"1\"> (25)</font></center></html>\\n");
            jButton51.setMaximumSize(new java.awt.Dimension(85, 52));
            jButton51.setMinimumSize(new java.awt.Dimension(85, 52));
            jButton51.setPreferredSize(new java.awt.Dimension(85, 52));
            jButton51.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton51ActionPerformed(evt);
                }
            });

            jButton58.setBackground(new java.awt.Color(255, 255, 255));
            jButton58.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
            jButton58.setText("<html><center><font color=\"orange\">sa<sup>1</sup>ta<sup>4</sup></font><br>ta<sup>1</sup>xi<sup>4</sup><br><font size=\"1\"> (58)</font></center></html>\\n");
            jButton58.setMaximumSize(new java.awt.Dimension(85, 52));
            jButton58.setMinimumSize(new java.awt.Dimension(85, 52));
            jButton58.setPreferredSize(new java.awt.Dimension(85, 52));
            jButton58.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton58ActionPerformed(evt);
                }
            });

            jButton50.setBackground(new java.awt.Color(255, 255, 255));
            jButton50.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
            jButton50.setText("<html><center><font color=\"orange\">si'<sup>1</sup>in<sup>3</sup></font><br><font size=\"1\"> (4)</font></center></html>\\n");
            jButton50.setMaximumSize(new java.awt.Dimension(85, 52));
            jButton50.setMinimumSize(new java.awt.Dimension(85, 52));
            jButton50.setPreferredSize(new java.awt.Dimension(85, 52));
            jButton50.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton50ActionPerformed(evt);
                }
            });

            jButton57real.setBackground(new java.awt.Color(255, 255, 255));
            jButton57real.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
            jButton57real.setText("<html><center><font color=\"orange\">ti'<sup>1</sup>in<sup>4</sup></font><br><font size=\"1\"> (2)</font></center></html>\\n");
            jButton57real.setMaximumSize(new java.awt.Dimension(85, 52));
            jButton57real.setMinimumSize(new java.awt.Dimension(85, 52));
            jButton57real.setPreferredSize(new java.awt.Dimension(85, 52));
            jButton57real.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton57realActionPerformed(evt);
                }
            });

            jButton49.setBackground(new java.awt.Color(255, 255, 255));
            jButton49.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
            jButton49.setText("<html><center><font color=\"orange\">ta<sup>1</sup>an<sup>3</sup></font><br>ti<sup>1</sup>in<sup>3</sup><br><font size=\"1\"> (3)</font></center></html>\\n");
            jButton49.setMaximumSize(new java.awt.Dimension(85, 52));
            jButton49.setMinimumSize(new java.awt.Dimension(85, 52));
            jButton49.setPreferredSize(new java.awt.Dimension(85, 52));
            jButton49.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton49ActionPerformed(evt);
                }
            });

            jButton56.setBackground(new java.awt.Color(255, 255, 255));
            jButton56.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
            jButton56.setText("<html><center><font color=\"orange\">ja<sup>1</sup>an<sup>4</sup></font><br>xi<sup>1</sup>in<sup>4</sup><br><font size=\"1\"> (8)</font></center></html>\\n");
            jButton56.setMaximumSize(new java.awt.Dimension(85, 52));
            jButton56.setMinimumSize(new java.awt.Dimension(85, 52));
            jButton56.setPreferredSize(new java.awt.Dimension(85, 52));
            jButton56.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton56ActionPerformed(evt);
                }
            });

            jButton68.setBackground(new java.awt.Color(255, 255, 255));
            jButton68.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
            jButton68.setText("<html><center><font color=\"orange\">ti'<sup>13</sup>in<sup>2</sup></font><br><font size=\"1\"> (1)</font></center></html>\\n");
            jButton68.setMaximumSize(new java.awt.Dimension(85, 52));
            jButton68.setMinimumSize(new java.awt.Dimension(85, 52));
            jButton68.setPreferredSize(new java.awt.Dimension(85, 52));
            jButton68.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton68ActionPerformed(evt);
                }
            });

            jButton69.setBackground(new java.awt.Color(255, 255, 255));
            jButton69.setFont(new java.awt.Font("Lucida Grande", 0, 9)); // NOI18N
            jButton69.setText("<html><center><font color=\"orange\">su<sup>13</sup>nda<sup>2</sup></font><br><font size=\"1\"> (20)</font></center></html>\\n");
            jButton69.setMaximumSize(new java.awt.Dimension(85, 52));
            jButton69.setMinimumSize(new java.awt.Dimension(85, 52));
            jButton69.setPreferredSize(new java.awt.Dimension(85, 52));
            jButton69.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton69ActionPerformed(evt);
                }
            });

            jButton70.setBackground(new java.awt.Color(255, 255, 255));
            jButton70.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
            jButton70.setText("<html><center><font color=\"orange\">ti'<sup>13</sup>bi<sup>2</sup></font><br><font size=\"1\"> (1)</font></center></html>\\n");
            jButton70.setMaximumSize(new java.awt.Dimension(95, 52));
            jButton70.setMinimumSize(new java.awt.Dimension(95, 52));
            jButton70.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton70ActionPerformed(evt);
                }
            });

            jButton71.setBackground(new java.awt.Color(255, 255, 255));
            jButton71.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
            jButton71.setText("<html><center><font color=\"orange\">xu<sup>13</sup>xa<sup>3</sup></font><br><font size=\"1\"> (4)</font></center></html>\\n");
            jButton71.setMaximumSize(new java.awt.Dimension(85, 52));
            jButton71.setMinimumSize(new java.awt.Dimension(85, 52));
            jButton71.setPreferredSize(new java.awt.Dimension(85, 52));
            jButton71.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton71ActionPerformed(evt);
                }
            });

            jButton72.setBackground(new java.awt.Color(255, 255, 255));
            jButton72.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
            jButton72.setText("<html><center><font color=\"orange\">ti<sup>13</sup>bi<sup>4</sup></font><br><font size=\"1\"> (2)</font></center></html>\\n");
            jButton72.setMaximumSize(new java.awt.Dimension(85, 52));
            jButton72.setMinimumSize(new java.awt.Dimension(85, 52));
            jButton72.setPreferredSize(new java.awt.Dimension(85, 52));
            jButton72.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton72ActionPerformed(evt);
                }
            });

            jButton73.setBackground(new java.awt.Color(255, 255, 255));
            jButton73.setFont(new java.awt.Font("Lucida Grande", 0, 9)); // NOI18N
            jButton73.setText("<html><center><font color=\"orange\">Ndw<sup>13</sup>xin<sup>4</sup></font><br><font size=\"1\"> (1, proper noun)</font></center></html>\\");
                jButton73.setMaximumSize(new java.awt.Dimension(95, 52));
                jButton73.setMinimumSize(new java.awt.Dimension(95, 52));
                jButton73.setPreferredSize(new java.awt.Dimension(95, 52));
                jButton73.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton73ActionPerformed(evt);
                    }
                });

                jButton74.setBackground(new java.awt.Color(255, 255, 255));
                jButton74.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                jButton74.setText("<html><center><font color=\"orange\">na'<sup>14</sup>o<sup>1</sup></font><br><font size=\"1\"> (1)</font></center></html>\\n");
                jButton74.setMaximumSize(new java.awt.Dimension(85, 52));
                jButton74.setMinimumSize(new java.awt.Dimension(85, 52));
                jButton74.setPreferredSize(new java.awt.Dimension(85, 52));
                jButton74.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton74ActionPerformed(evt);
                    }
                });

                jButton75.setBackground(new java.awt.Color(255, 255, 255));
                jButton75.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                jButton75.setText("<html><center><font color=\"orange\">chu'<sup>13</sup>ma<sup>1</sup></font><br><font size=\"1\"> (4)</font></center></html>\\n");
                jButton75.setMaximumSize(new java.awt.Dimension(95, 52));
                jButton75.setMinimumSize(new java.awt.Dimension(95, 52));
                jButton75.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton75ActionPerformed(evt);
                    }
                });

                jButton76.setBackground(new java.awt.Color(255, 255, 255));
                jButton76.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton76.setText("<html><center><font color=\"orange\">ndu<sup>14</sup>u<sup>2</sup></font><br>to<sup>14</sup>o<sup>2</sup><br><font size=\"1\"> (4)</font></center></html>\\n");
                jButton76.setMaximumSize(new java.awt.Dimension(85, 52));
                jButton76.setMinimumSize(new java.awt.Dimension(85, 52));
                jButton76.setPreferredSize(new java.awt.Dimension(85, 52));
                jButton76.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton76ActionPerformed(evt);
                    }
                });

                jButton77.setBackground(new java.awt.Color(255, 255, 255));
                jButton77.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                jButton77.setText("<html><center><font color=\"orange\">na'<sup>14</sup>a<sup>2</sup></font><br>se'<sup>14</sup>e<sup>2</sup><br><font size=\"1\"> (2)</font></center></html>\\n");
                jButton77.setMaximumSize(new java.awt.Dimension(85, 52));
                jButton77.setMinimumSize(new java.awt.Dimension(85, 52));
                jButton77.setPreferredSize(new java.awt.Dimension(85, 52));
                jButton77.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton77ActionPerformed(evt);
                    }
                });

                jButton78.setBackground(new java.awt.Color(255, 255, 255));
                jButton78.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton78.setText("<html><center><font color=\"orange\">xa'<sup>14</sup>an<sup>2</sup></font><br><font size=\"1\"> (4)</font></center></html>\\n");
                jButton78.setMaximumSize(new java.awt.Dimension(85, 52));
                jButton78.setMinimumSize(new java.awt.Dimension(85, 52));
                jButton78.setPreferredSize(new java.awt.Dimension(85, 52));
                jButton78.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton78ActionPerformed(evt);
                    }
                });

                jButton79.setBackground(new java.awt.Color(255, 255, 255));
                jButton79.setFont(new java.awt.Font("Lucida Grande", 0, 9)); // NOI18N
                jButton79.setText("<html><center><font color=\"orange\">xi<sup>14</sup>nda<sup>2</sup></font><br><font color=\"orange\">xa<sup>14</sup>bi<sup>2</sup></font><br><font size=\"1\"> (23)</font></center></html>\\n");
                jButton79.setMaximumSize(new java.awt.Dimension(85, 52));
                jButton79.setMinimumSize(new java.awt.Dimension(85, 52));
                jButton79.setPreferredSize(new java.awt.Dimension(85, 52));
                jButton79.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton79ActionPerformed(evt);
                    }
                });

                jButton80.setBackground(new java.awt.Color(255, 255, 255));
                jButton80.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                jButton80.setText("<html><center><font color=\"orange\">yu'<sup>14</sup>bi<sup>2</sup></font><br><font size=\"1\"> (1)</font></center></html>\\n");
                jButton80.setMaximumSize(new java.awt.Dimension(95, 52));
                jButton80.setMinimumSize(new java.awt.Dimension(95, 52));
                jButton80.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jButton80ActionPerformed(evt);
                    }
                });

                jButton81.setBackground(new java.awt.Color(255, 255, 255));
                jButton81.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                jButton81.setText("<html><center><font color=\"orange\">ya<sup>14</sup>kun<sup>2</sup></font><br><font size=\"1\"> (1)</font></center></html>\\");
                    jButton81.setMaximumSize(new java.awt.Dimension(95, 52));
                    jButton81.setMinimumSize(new java.awt.Dimension(95, 52));
                    jButton81.setPreferredSize(new java.awt.Dimension(95, 52));
                    jButton81.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton81ActionPerformed(evt);
                        }
                    });

                    jButton82.setBackground(new java.awt.Color(255, 255, 255));
                    jButton82.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                    jButton82.setText("<html><center><font color=\"orange\">su<sup>14</sup>u<sup>3</sup></font><br>ko<sup>14</sup>o<sup>3</sup><br><font size=\"1\"> (7)</font></center></html>\\n");
                    jButton82.setMaximumSize(new java.awt.Dimension(85, 52));
                    jButton82.setMinimumSize(new java.awt.Dimension(85, 52));
                    jButton82.setPreferredSize(new java.awt.Dimension(85, 52));
                    jButton82.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton82ActionPerformed(evt);
                        }
                    });

                    jButton83.setBackground(new java.awt.Color(255, 255, 255));
                    jButton83.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                    jButton83.setText("<html><center><font color=\"orange\">tu<sup>14</sup>un<sup>3</sup></font><br><font size=\"1\"> (3)</font></center></html>\\n");
                    jButton83.setMaximumSize(new java.awt.Dimension(85, 52));
                    jButton83.setMinimumSize(new java.awt.Dimension(85, 52));
                    jButton83.setPreferredSize(new java.awt.Dimension(85, 52));
                    jButton83.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton83ActionPerformed(evt);
                        }
                    });

                    jButton84.setBackground(new java.awt.Color(255, 255, 255));
                    jButton84.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                    jButton84.setText("<html><center><font color=\"orange\">ba<sup>14</sup>sa<sup>3</sup></font><br><font color=\"orange\">yu<sup>14</sup>ti<sup>3</sup></font><br><font size=\"1\"> (23)</font></center></html>\\n");
                    jButton84.setMaximumSize(new java.awt.Dimension(85, 52));
                    jButton84.setMinimumSize(new java.awt.Dimension(85, 52));
                    jButton84.setPreferredSize(new java.awt.Dimension(85, 52));
                    jButton84.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton84ActionPerformed(evt);
                        }
                    });

                    jButton85.setBackground(new java.awt.Color(255, 255, 255));
                    jButton85.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                    jButton85.setText("<html><center><font color=\"orange\">si'<sup>14</sup>bi<sup>3</sup></font><br><font size=\"1\"> (6)</font></center></html>\\n");
                    jButton85.setMaximumSize(new java.awt.Dimension(95, 52));
                    jButton85.setMinimumSize(new java.awt.Dimension(95, 52));
                    jButton85.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton85ActionPerformed(evt);
                        }
                    });

                    jButton86.setBackground(new java.awt.Color(255, 255, 255));
                    jButton86.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                    jButton86.setText("<html><center><font color=\"orange\">yu<sup>14</sup>kun<sup>3</sup></font><br><font size=\"1\"> (4)</font></center></html>\\");
                        jButton86.setMaximumSize(new java.awt.Dimension(95, 52));
                        jButton86.setMinimumSize(new java.awt.Dimension(95, 52));
                        jButton86.setPreferredSize(new java.awt.Dimension(95, 52));
                        jButton86.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton86ActionPerformed(evt);
                            }
                        });

                        jButton87.setBackground(new java.awt.Color(255, 255, 255));
                        jButton87.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                        jButton87.setText("<html><center><font color=\"orange\">na'<sup>14</sup>a<sup>4</sup></font><br>nde'<sup>14</sup>e<sup>4</sup><br><font size=\"1\"> (12)</font></center></html>\\n");
                        jButton87.setMaximumSize(new java.awt.Dimension(85, 52));
                        jButton87.setMinimumSize(new java.awt.Dimension(85, 52));
                        jButton87.setPreferredSize(new java.awt.Dimension(85, 52));
                        jButton87.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton87ActionPerformed(evt);
                            }
                        });

                        jButton88.setBackground(new java.awt.Color(255, 255, 255));
                        jButton88.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                        jButton88.setText("<html><center><font color=\"orange\">xu'<sup>14</sup>un<sup>4</sup></font><br><font size=\"1\"> (2)</font></center></html>\\n");
                        jButton88.setMaximumSize(new java.awt.Dimension(85, 52));
                        jButton88.setMinimumSize(new java.awt.Dimension(85, 52));
                        jButton88.setPreferredSize(new java.awt.Dimension(85, 52));
                        jButton88.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton88ActionPerformed(evt);
                            }
                        });

                        jButton89.setBackground(new java.awt.Color(255, 255, 255));
                        jButton89.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                        jButton89.setText("<html><center><font color=\"orange\">ba<sup>14</sup>sa<sup>4</sup></font><br><font color=\"orange\">yu<sup>14</sup>bi<sup>4</sup></font><br><font size=\"1\"> (19)</font></center></html>\\n");
                        jButton89.setMaximumSize(new java.awt.Dimension(85, 52));
                        jButton89.setMinimumSize(new java.awt.Dimension(85, 52));
                        jButton89.setPreferredSize(new java.awt.Dimension(85, 52));
                        jButton89.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton89ActionPerformed(evt);
                            }
                        });

                        jButton90.setBackground(new java.awt.Color(255, 255, 255));
                        jButton90.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                        jButton90.setText("<html><center><font color=\"orange\">xa<sup>14</sup>tun<sup>4</sup></font><br><font size=\"1\"> (3)</font></center></html>\\");
                            jButton90.setMaximumSize(new java.awt.Dimension(95, 52));
                            jButton90.setMinimumSize(new java.awt.Dimension(95, 52));
                            jButton90.setPreferredSize(new java.awt.Dimension(95, 52));
                            jButton90.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    jButton90ActionPerformed(evt);
                                }
                            });

                            jButton91.setBackground(new java.awt.Color(255, 255, 255));
                            jButton91.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                            jButton91.setText("<html><center><font color=\"orange\">ti<sup>1</sup>xa<sup>42</sup></font><br><font size=\"1\"> (5)</font></center></html>\\n");
                            jButton91.setMaximumSize(new java.awt.Dimension(85, 52));
                            jButton91.setMinimumSize(new java.awt.Dimension(85, 52));
                            jButton91.setPreferredSize(new java.awt.Dimension(85, 52));
                            jButton91.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    jButton91ActionPerformed(evt);
                                }
                            });

                            jButton92.setBackground(new java.awt.Color(255, 255, 255));
                            jButton92.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                            jButton92.setText("<html><center><font color=\"orange\">chi'<sup>1</sup>li<sup>42</sup></font><br><font size=\"1\"> (1)</font></center></html>\\n");
                            jButton92.setMaximumSize(new java.awt.Dimension(95, 52));
                            jButton92.setMinimumSize(new java.awt.Dimension(95, 52));
                            jButton92.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                    jButton92ActionPerformed(evt);
                                }
                            });

                            jButton93.setBackground(new java.awt.Color(255, 255, 255));
                            jButton93.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                            jButton93.setText("<html><center><font color=\"orange\">ti<sup>1</sup>sun<sup>42</sup></font><br><font size=\"1\"> (1)</font></center></html>\\");
                                jButton93.setMaximumSize(new java.awt.Dimension(95, 52));
                                jButton93.setMinimumSize(new java.awt.Dimension(95, 52));
                                jButton93.setPreferredSize(new java.awt.Dimension(95, 52));
                                jButton93.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        jButton93ActionPerformed(evt);
                                    }
                                });

                                jButton94.setBackground(new java.awt.Color(255, 255, 255));
                                jButton94.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                jButton94.setText("<html><center><font color=\"orange\">si<sup>1</sup>xa<sup>3</sup></font><br><font size=\"1\"> (2)</font></center></html>\\n");
                                jButton94.setMaximumSize(new java.awt.Dimension(85, 52));
                                jButton94.setMinimumSize(new java.awt.Dimension(85, 52));
                                jButton94.setPreferredSize(new java.awt.Dimension(85, 52));
                                jButton94.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        jButton94ActionPerformed(evt);
                                    }
                                });

                                jButton95.setBackground(new java.awt.Color(255, 255, 255));
                                jButton95.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                                jButton95.setText("<html><center><font color=\"orange\">che<sup>1</sup>e<sup>32</sup></font><br><font size=\"1\"> (2)</font></center></html>\\n");
                                jButton95.setMaximumSize(new java.awt.Dimension(85, 52));
                                jButton95.setMinimumSize(new java.awt.Dimension(85, 52));
                                jButton95.setPreferredSize(new java.awt.Dimension(85, 52));
                                jButton95.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        jButton95ActionPerformed(evt);
                                    }
                                });

                                jButton96.setBackground(new java.awt.Color(255, 255, 255));
                                jButton96.setFont(new java.awt.Font("Lucida Grande", 0, 9)); // NOI18N
                                jButton96.setText("<html><center><font color=\"orange\">ndu<sup>1</sup>xa<sup>32</sup></font><br><font size=\"1\"> (25)</font></center></html>\\n");
                                jButton96.setMaximumSize(new java.awt.Dimension(85, 52));
                                jButton96.setMinimumSize(new java.awt.Dimension(85, 52));
                                jButton96.setPreferredSize(new java.awt.Dimension(85, 52));
                                jButton96.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        jButton96ActionPerformed(evt);
                                    }
                                });

                                jButton97.setBackground(new java.awt.Color(255, 255, 255));
                                jButton97.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                jButton97.setText("<html><center><font color=\"orange\">xa'<sup>1</sup>bi<sup>32</sup></font><br><font size=\"1\"> (1)</font></center></html>\\n");
                                jButton97.setMaximumSize(new java.awt.Dimension(95, 52));
                                jButton97.setMinimumSize(new java.awt.Dimension(95, 52));
                                jButton97.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        jButton97ActionPerformed(evt);
                                    }
                                });

                                jButton98.setBackground(new java.awt.Color(255, 255, 255));
                                jButton98.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                jButton98.setText("<html><center><font color=\"orange\">ñu<sup>3</sup>u<sup>42</sup></font><br><font size=\"1\"> (1)</font></center></html>\\n");
                                jButton98.setMaximumSize(new java.awt.Dimension(85, 52));
                                jButton98.setMinimumSize(new java.awt.Dimension(85, 52));
                                jButton98.setPreferredSize(new java.awt.Dimension(85, 52));
                                jButton98.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        jButton98ActionPerformed(evt);
                                    }
                                });

                                jButton99.setBackground(new java.awt.Color(255, 255, 255));
                                jButton99.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                                jButton99.setText("<html><center><font color=\"orange\">chi'<sup>3</sup>i<sup>42</sup></font><br><font size=\"1\"> (1 vocativo)</font></center></html>\\n");
                                jButton99.setMaximumSize(new java.awt.Dimension(85, 52));
                                jButton99.setMinimumSize(new java.awt.Dimension(85, 52));
                                jButton99.setPreferredSize(new java.awt.Dimension(85, 52));
                                jButton99.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        jButton99ActionPerformed(evt);
                                    }
                                });

                                jButton100.setBackground(new java.awt.Color(255, 255, 255));
                                jButton100.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                jButton100.setText("<html><center><font color=\"orange\">i<sup>3</sup>sa<sup>42</sup></font><br><font size=\"1\"> (9)</font></center></html>\\n");
                                jButton100.setMaximumSize(new java.awt.Dimension(85, 52));
                                jButton100.setMinimumSize(new java.awt.Dimension(85, 52));
                                jButton100.setPreferredSize(new java.awt.Dimension(85, 52));
                                jButton100.addActionListener(new java.awt.event.ActionListener() {
                                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        jButton100ActionPerformed(evt);
                                    }
                                });

                                jButton101.setBackground(new java.awt.Color(255, 255, 255));
                                jButton101.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                jButton101.setText("<html><center><font color=\"orange\">ke<sup>3</sup>kun<sup>42</sup></font><br><font size=\"1\"> (3)</font></center></html>\\");
                                    jButton101.setMaximumSize(new java.awt.Dimension(95, 52));
                                    jButton101.setMinimumSize(new java.awt.Dimension(95, 52));
                                    jButton101.setPreferredSize(new java.awt.Dimension(95, 52));
                                    jButton101.addActionListener(new java.awt.event.ActionListener() {
                                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            jButton101ActionPerformed(evt);
                                        }
                                    });

                                    jButton102.setBackground(new java.awt.Color(255, 255, 255));
                                    jButton102.setFont(new java.awt.Font("Lucida Grande", 0, 9)); // NOI18N
                                    jButton102.setText("<html><center><font color=\"orange\">sta<sup>4</sup>ta<sup>42</sup></font><br><font size=\"1\"> (1, historical sandhi?)</font></center></html>\\n");
                                    jButton102.setMaximumSize(new java.awt.Dimension(85, 52));
                                    jButton102.setMinimumSize(new java.awt.Dimension(85, 52));
                                    jButton102.setPreferredSize(new java.awt.Dimension(85, 52));
                                    jButton102.addActionListener(new java.awt.event.ActionListener() {
                                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            jButton102ActionPerformed(evt);
                                        }
                                    });

                                    jButton103.setBackground(new java.awt.Color(255, 255, 255));
                                    jButton103.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                    jButton103.setText("<html><center><font color=\"orange\">che<sup>4</sup>i<sup>13</sup></font><br><font size=\"1\"> (1)</font></center></html>\\n");
                                    jButton103.setMaximumSize(new java.awt.Dimension(85, 52));
                                    jButton103.setMinimumSize(new java.awt.Dimension(85, 52));
                                    jButton103.setPreferredSize(new java.awt.Dimension(85, 52));
                                    jButton103.addActionListener(new java.awt.event.ActionListener() {
                                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            jButton103ActionPerformed(evt);
                                        }
                                    });

                                    jButton104.setBackground(new java.awt.Color(255, 255, 255));
                                    jButton104.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                    jButton104.setText("<html><center><font color=\"orange\">xa'<sup>4</sup>i<sup>13</sup></font><br><font size=\"1\"> (2)</font></center></html>\\n");
                                    jButton104.setMaximumSize(new java.awt.Dimension(85, 52));
                                    jButton104.setMinimumSize(new java.awt.Dimension(85, 52));
                                    jButton104.setPreferredSize(new java.awt.Dimension(85, 52));
                                    jButton104.addActionListener(new java.awt.event.ActionListener() {
                                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            jButton104ActionPerformed(evt);
                                        }
                                    });

                                    jButton105.setBackground(new java.awt.Color(255, 255, 255));
                                    jButton105.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                    jButton105.setText("<html><center><font color=\"orange\">xi'<sup>4</sup>in<sup>13</sup></font><br><font size=\"1\"> (1)</font></center></html>\\n");
                                    jButton105.setMaximumSize(new java.awt.Dimension(85, 52));
                                    jButton105.setMinimumSize(new java.awt.Dimension(85, 52));
                                    jButton105.setPreferredSize(new java.awt.Dimension(85, 52));
                                    jButton105.addActionListener(new java.awt.event.ActionListener() {
                                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            jButton105ActionPerformed(evt);
                                        }
                                    });

                                    jButton106.setBackground(new java.awt.Color(255, 255, 255));
                                    jButton106.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                    jButton106.setText("<html><center><font color=\"orange\">xi<sup>4</sup>yo<sup>13</sup></font><br><font size=\"1\"> (6)</font></center></html>\\n");
                                    jButton106.setMaximumSize(new java.awt.Dimension(85, 52));
                                    jButton106.setMinimumSize(new java.awt.Dimension(85, 52));
                                    jButton106.setPreferredSize(new java.awt.Dimension(85, 52));
                                    jButton106.addActionListener(new java.awt.event.ActionListener() {
                                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            jButton106ActionPerformed(evt);
                                        }
                                    });

                                    jButton107.setBackground(new java.awt.Color(255, 255, 255));
                                    jButton107.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                    jButton107.setText("<html><center><font color=\"orange\">xa'<sup>4</sup>nu<sup>13</sup></font><br><font size=\"1\"> (4)</font></center></html>\\n");
                                    jButton107.setMaximumSize(new java.awt.Dimension(95, 52));
                                    jButton107.setMinimumSize(new java.awt.Dimension(95, 52));
                                    jButton107.addActionListener(new java.awt.event.ActionListener() {
                                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            jButton107ActionPerformed(evt);
                                        }
                                    });

                                    jButton108.setBackground(new java.awt.Color(255, 255, 255));
                                    jButton108.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                    jButton108.setText("<html><center><font color=\"orange\">xa<sup>4</sup>xin<sup>13</sup></font><br><font size=\"1\"> (1)</font></center></html>\\");
                                        jButton108.setMaximumSize(new java.awt.Dimension(95, 52));
                                        jButton108.setMinimumSize(new java.awt.Dimension(95, 52));
                                        jButton108.setPreferredSize(new java.awt.Dimension(95, 52));
                                        jButton108.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jButton108ActionPerformed(evt);
                                            }
                                        });

                                        jButton109.setBackground(new java.awt.Color(255, 255, 255));
                                        jButton109.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                        jButton109.setText("<html><center><font color=\"orange\">xi<sup>4</sup>ya<sup>14</sup></font><br><font size=\"1\"> (5)</font></center></html>\\n");
                                        jButton109.setMaximumSize(new java.awt.Dimension(85, 52));
                                        jButton109.setMinimumSize(new java.awt.Dimension(85, 52));
                                        jButton109.setPreferredSize(new java.awt.Dimension(85, 52));
                                        jButton109.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jButton109ActionPerformed(evt);
                                            }
                                        });

                                        jButton110.setBackground(new java.awt.Color(255, 255, 255));
                                        jButton110.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                        jButton110.setText("<html><center><font color=\"orange\">ka'<sup>4</sup>yu<sup>14</sup></font><br><font size=\"1\"> (2)</font></center></html>\\n");
                                        jButton110.setMaximumSize(new java.awt.Dimension(95, 52));
                                        jButton110.setMinimumSize(new java.awt.Dimension(95, 52));
                                        jButton110.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jButton110ActionPerformed(evt);
                                            }
                                        });

                                        jButton111.setBackground(new java.awt.Color(255, 255, 255));
                                        jButton111.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                        jButton111.setText("<html><center><font color=\"orange\">ya<sup>4</sup>a<sup>24</sup></font><br><font size=\"1\"> (9)</font></center></html>\\n");
                                        jButton111.setMaximumSize(new java.awt.Dimension(85, 52));
                                        jButton111.setMinimumSize(new java.awt.Dimension(85, 52));
                                        jButton111.setPreferredSize(new java.awt.Dimension(85, 52));
                                        jButton111.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jButton111ActionPerformed(evt);
                                            }
                                        });

                                        jButton112.setBackground(new java.awt.Color(255, 255, 255));
                                        jButton112.setFont(new java.awt.Font("Lucida Grande", 0, 9)); // NOI18N
                                        jButton112.setText("<html><center><font color=\"orange\">kwa<sup>4</sup>an<sup>24</sup></font><br><font color=\"orange\">ta<sup>4</sup>an<sup>24</sup></font><br><font size=\"1\"> (4)</font></center></html>\\n");
                                        jButton112.setMaximumSize(new java.awt.Dimension(85, 52));
                                        jButton112.setMinimumSize(new java.awt.Dimension(85, 52));
                                        jButton112.setPreferredSize(new java.awt.Dimension(85, 52));
                                        jButton112.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jButton112ActionPerformed(evt);
                                            }
                                        });

                                        jButton113.setBackground(new java.awt.Color(255, 255, 255));
                                        jButton113.setFont(new java.awt.Font("Lucida Grande", 0, 9)); // NOI18N
                                        jButton113.setText("<html><center><font color=\"orange\">ndu<sup>4</sup>xa<sup>24</sup></font><br><font size=\"1\"> (21)</font></center></html>\\n");
                                        jButton113.setMaximumSize(new java.awt.Dimension(85, 52));
                                        jButton113.setMinimumSize(new java.awt.Dimension(85, 52));
                                        jButton113.setPreferredSize(new java.awt.Dimension(85, 52));
                                        jButton113.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jButton113ActionPerformed(evt);
                                            }
                                        });

                                        jButton114.setBackground(new java.awt.Color(255, 255, 255));
                                        jButton114.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                        jButton114.setText("<html><center><font color=\"orange\">xa'<sup>4</sup>ni<sup>24</sup></font><br><font size=\"1\"> (1)</font></center></html>\\n");
                                        jButton114.setMaximumSize(new java.awt.Dimension(95, 52));
                                        jButton114.setMinimumSize(new java.awt.Dimension(95, 52));
                                        jButton114.addActionListener(new java.awt.event.ActionListener() {
                                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                jButton114ActionPerformed(evt);
                                            }
                                        });

                                        jButton115.setBackground(new java.awt.Color(255, 255, 255));
                                        jButton115.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                        jButton115.setText("<html><center><font color=\"orange\">ta<sup>4</sup>xin<sup>24</sup></font><br><font size=\"1\"> (2)</font></center></html>\\");
                                            jButton115.setMaximumSize(new java.awt.Dimension(95, 52));
                                            jButton115.setMinimumSize(new java.awt.Dimension(95, 52));
                                            jButton115.setPreferredSize(new java.awt.Dimension(95, 52));
                                            jButton115.addActionListener(new java.awt.event.ActionListener() {
                                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                    jButton115ActionPerformed(evt);
                                                }
                                            });

                                            jButton116.setBackground(new java.awt.Color(255, 255, 255));
                                            jButton116.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                            jButton116.setText("<html><center>kia'<sup>3</sup>bi<sup>13</sup><br><font size=\"1\"> (1)</font></center></html>\\n");
                                            jButton116.setMaximumSize(new java.awt.Dimension(95, 52));
                                            jButton116.setMinimumSize(new java.awt.Dimension(95, 52));
                                            jButton116.addActionListener(new java.awt.event.ActionListener() {
                                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                    jButton116ActionPerformed(evt);
                                                }
                                            });

                                            jButton117.setBackground(new java.awt.Color(255, 255, 255));
                                            jButton117.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                            jButton117.setText("<html><center><br>i<sup>3</sup>nda<sup>14</sup><br><font size=\"1\"> (1)</font></center></html>\\n");
                                            jButton117.setMaximumSize(new java.awt.Dimension(85, 52));
                                            jButton117.setMinimumSize(new java.awt.Dimension(85, 52));
                                            jButton117.setPreferredSize(new java.awt.Dimension(85, 52));
                                            jButton117.addActionListener(new java.awt.event.ActionListener() {
                                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                    jButton117ActionPerformed(evt);
                                                }
                                            });

                                            jButton118.setBackground(new java.awt.Color(255, 255, 255));
                                            jButton118.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                            jButton118.setText("<html><center>ti<sup>4</sup>ko<sup>34</sup><br><font size=\"1\"> (1, pronunciation varies)</font></center></html>\\n");
                                            jButton118.setMaximumSize(new java.awt.Dimension(85, 52));
                                            jButton118.setMinimumSize(new java.awt.Dimension(85, 52));
                                            jButton118.setPreferredSize(new java.awt.Dimension(85, 52));
                                            jButton118.addActionListener(new java.awt.event.ActionListener() {
                                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                    jButton118ActionPerformed(evt);
                                                }
                                            });

                                            jButton119.setBackground(new java.awt.Color(255, 255, 255));
                                            jButton119.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                            jButton119.setText("<html><center>ba<sup>143</sup><br>ja<sup>143</sup><br><font size=\"1\"> (3)</font></center></html>\\n");
                                            jButton119.setMaximumSize(new java.awt.Dimension(85, 52));
                                            jButton119.setMinimumSize(new java.awt.Dimension(85, 52));
                                            jButton119.setPreferredSize(new java.awt.Dimension(85, 52));
                                            jButton119.addActionListener(new java.awt.event.ActionListener() {
                                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                    jButton119ActionPerformed(evt);
                                                }
                                            });

                                            jButton120.setBackground(new java.awt.Color(255, 255, 255));
                                            jButton120.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                            jButton120.setText("<html><center>pi'<sup>1</sup>la<sup>4</sup>xi<sup>132</sup><br><font size=\"1\"> (1)</font></center></html>\\n");
                                            jButton120.setMaximumSize(new java.awt.Dimension(85, 52));
                                            jButton120.setMinimumSize(new java.awt.Dimension(85, 52));
                                            jButton120.setPreferredSize(new java.awt.Dimension(85, 52));
                                            jButton120.addActionListener(new java.awt.event.ActionListener() {
                                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                    jButton120ActionPerformed(evt);
                                                }
                                            });

                                            jButton121.setBackground(new java.awt.Color(255, 255, 255));
                                            jButton121.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
                                            jButton121.setText("<html><center>ku<sup>4</sup>tu<sup>1</sup>pi<sup>132</sup><br><font size=\"1\"> (1)</font></center></html>\\n");
                                            jButton121.setMaximumSize(new java.awt.Dimension(85, 52));
                                            jButton121.setMinimumSize(new java.awt.Dimension(85, 52));
                                            jButton121.setPreferredSize(new java.awt.Dimension(85, 52));
                                            jButton121.addActionListener(new java.awt.event.ActionListener() {
                                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                    jButton121ActionPerformed(evt);
                                                }
                                            });

                                            jLabel2.setText("1.1");

                                            jLabel3.setText("4.4");

                                            jLabel4.setText("3.3");

                                            jLabel5.setText("4.1");

                                            jLabel6.setText("4.2");

                                            jLabel7.setText("4.3");

                                            jLabel8.setText("3.2");

                                            jLabel9.setText("1.3");

                                            jLabel10.setText("1.4");

                                            jLabel11.setText("3.4");

                                            jLabel12.setText("13.2");

                                            jLabel13.setText("13.3");

                                            jLabel14.setText("13.4");

                                            jLabel15.setText("14.1");

                                            jLabel16.setText("14.2");

                                            jLabel17.setText("14.3");

                                            jLabel18.setText("14.4");

                                            jLabel19.setText("1.42");

                                            jLabel20.setText("1.43");

                                            jLabel21.setText("1.32");

                                            jLabel22.setText("3.42");

                                            jLabel23.setText("4.42");

                                            jLabel24.setText("4.13");

                                            jLabel25.setText("4.14");

                                            jLabel26.setText("4.24");

                                            jLabel27.setText("3.13");

                                            jLabel28.setText("3.14");

                                            jLabel29.setText("132");

                                            jLabel30.setText("4.34");

                                            jLabel31.setText("143");

                                            jLabel32.setText("342");

                                            jLabel33.setText("Complex Tones");

                                            jLabel34.setText("Rare Tones");

                                            javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
                                            jLayeredPane5.setLayout(jLayeredPane5Layout);
                                            jLayeredPane5Layout.setHorizontalGroup(
                                                jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                    .addGap(26, 26, 26)
                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel11)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel12)
                                                        .addComponent(jLabel13)
                                                        .addComponent(jLabel14)
                                                        .addComponent(jLabel15)
                                                        .addComponent(jLabel16)
                                                        .addComponent(jLabel17)
                                                        .addComponent(jLabel18)
                                                        .addComponent(jLabel19)
                                                        .addComponent(jLabel20)
                                                        .addComponent(jLabel21)
                                                        .addComponent(jLabel22)
                                                        .addComponent(jLabel23)
                                                        .addComponent(jLabel24)
                                                        .addComponent(jLabel25)
                                                        .addComponent(jLabel26)
                                                        .addComponent(jLabel27)
                                                        .addComponent(jLabel28)
                                                        .addComponent(jLabel29)
                                                        .addComponent(jLabel30)
                                                        .addComponent(jLabel32)
                                                        .addComponent(jLabel31))
                                                    .addGap(10, 10, 10)
                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                            .addComponent(jLabel33)
                                                            .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                    .addComponent(jButton95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addGap(279, 279, 279)
                                                                                    .addComponent(jButton96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton97, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jButton94, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jButton91, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton92, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addComponent(jButton93, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                    .addComponent(jButton116, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel34)
                                                                                        .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane5Layout.createSequentialGroup()
                                                                                                .addComponent(jButton111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                    .addComponent(jButton117, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                    .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                                        .addComponent(jButton113, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(jButton114, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                    .addComponent(jButton118, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                                .addComponent(jButton103, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jButton104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(94, 94, 94)
                                                                                                .addComponent(jButton105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                    .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                                        .addComponent(jButton106, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(jButton107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                    .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                                        .addComponent(jButton109, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                        .addComponent(jButton110, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                    .addComponent(jButton98, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jButton87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                            .addComponent(jButton99, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addGap(188, 188, 188)
                                                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(jButton102, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jButton100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jButton101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jButton115, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jButton108, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                    .addGap(6, 6, 6))
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane5Layout.createSequentialGroup()
                                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                            .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                            .addComponent(jButton28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                            .addComponent(jButton29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addComponent(jButton35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                            .addComponent(jButton40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                            .addComponent(jButton41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                            .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                            .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                            .addComponent(jButton30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                        .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                            .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                            .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                            .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                            .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                .addComponent(jButton24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(jButton31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(jButton43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addComponent(jButton36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                                    .addComponent(jButton32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                    .addComponent(jButton33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                    .addComponent(jButton34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                                    .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                    .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(jButton37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(jButton44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                                            .addComponent(jButton38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                            .addComponent(jButton39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                                            .addComponent(jButton45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                            .addComponent(jButton46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                    .addComponent(jButton54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton57real, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                    .addComponent(jButton47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                            .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                            .addGap(0, 0, Short.MAX_VALUE)
                                                                                            .addComponent(jButton88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                            .addComponent(jButton82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addGap(97, 97, 97)
                                                                                            .addComponent(jButton112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addGap(0, 0, Short.MAX_VALUE)))
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane5Layout.createSequentialGroup()
                                                                                            .addComponent(jButton84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                            .addComponent(jButton85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                            .addComponent(jButton89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addGap(107, 107, 107)))
                                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jButton86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jButton90, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jButton75, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane5Layout.createSequentialGroup()
                                                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                .addComponent(jButton83, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                                    .addComponent(jButton61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                    .addComponent(jButton62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                    .addComponent(jButton63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                    .addComponent(jButton68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(jButton71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                                            .addComponent(jButton69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                            .addComponent(jButton70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                        .addComponent(jButton72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                                    .addGap(5, 5, 5)
                                                                                                    .addComponent(jButton64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                    .addComponent(jButton65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                    .addComponent(jButton66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                    .addGap(0, 0, Short.MAX_VALUE)))))
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jButton67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jButton73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addComponent(jButton74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                                            .addComponent(jButton76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                            .addComponent(jButton77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                    .addGap(97, 97, 97)
                                                                                    .addComponent(jButton78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                    .addComponent(jButton81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                            .addGap(6, 6, 6)))
                                                                    .addGap(1, 1, 1)))
                                                            .addGap(16, 16, 16))
                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jButton119, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jButton120, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jButton121, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                            );
                                            jLayeredPane5Layout.setVerticalGroup(
                                                jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane5Layout.createSequentialGroup()
                                                    .addGap(0, 0, 0)
                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGap(20, 20, 20)
                                                                    .addComponent(jLabel2))
                                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGap(20, 20, 20)
                                                                    .addComponent(jLabel4))
                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGap(20, 20, 20)
                                                                    .addComponent(jLabel3)))
                                                            .addGap(40, 40, 40)
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGap(20, 20, 20)
                                                                    .addComponent(jLabel5)))
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGap(20, 20, 20)
                                                                    .addComponent(jLabel6)))
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGap(20, 20, 20)
                                                                    .addComponent(jLabel7)))
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGap(20, 20, 20)
                                                                    .addComponent(jLabel8)))
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGap(40, 40, 40)
                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                            .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                            .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane5Layout.createSequentialGroup()
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(jLabel9)
                                                                    .addGap(25, 25, 25)))
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton60, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(jButton57real, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGap(20, 20, 20)
                                                                    .addComponent(jLabel10)))
                                                            .addGap(0, 0, 0)
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                            .addComponent(jButton65, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jButton66, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jButton67, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                            .addComponent(jButton63, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jButton64, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addGap(34, 34, 34)
                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jButton68, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                            .addComponent(jButton69, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jButton70, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                    .addGap(0, 0, 0)
                                                                    .addComponent(jButton71, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGap(20, 20, 20)
                                                                    .addComponent(jLabel11)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(jLabel12)
                                                                    .addGap(42, 42, 42)
                                                                    .addComponent(jLabel13)
                                                                    .addGap(24, 24, 24)))
                                                            .addGap(20, 20, 20)
                                                            .addComponent(jLabel14)
                                                            .addGap(26, 26, 26))
                                                        .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jButton72, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jButton73, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGap(0, 0, 0)
                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton75, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jButton74, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel15)))
                                                    .addGap(0, 0, 0)
                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jButton80, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton81, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jButton77, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton76, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGap(20, 20, 20)
                                                                    .addComponent(jLabel16))
                                                                .addComponent(jButton78, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jButton85, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton86, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jButton83, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton82, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton84, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGap(20, 20, 20)
                                                                    .addComponent(jLabel17))))
                                                        .addComponent(jButton79, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jButton88, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jButton87, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGap(20, 20, 20)
                                                                    .addComponent(jLabel18))
                                                                .addComponent(jButton90, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGap(34, 34, 34)
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jButton91, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jButton92, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jButton93, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel19))
                                                            .addGap(0, 0, 0)
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jButton94, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel20))
                                                            .addGap(0, 0, 0)
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jButton96, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton97, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jButton95, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jLabel21)))
                                                            .addGap(0, 0, 0)
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jButton98, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel22))
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(jLabel23))
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                            .addComponent(jButton100, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jButton101, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jButton99, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addGap(0, 0, 0)
                                                                    .addComponent(jButton102, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addGap(0, 0, 0)
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jButton105, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jButton104, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButton103, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel24))
                                                                    .addGap(20, 20, 20)
                                                                    .addComponent(jLabel25))
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jButton106, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButton107, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButton108, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addGap(0, 0, 0)
                                                                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jButton109, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButton110, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                            .addGap(0, 0, 0)
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jButton113, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton114, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jButton115, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jButton111, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jLabel26))
                                                                .addComponent(jButton112, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGap(18, 18, 18)
                                                            .addComponent(jLabel34)
                                                            .addGap(14, 14, 14)
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jButton116, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel27))
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jButton117, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(jLabel28)))
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jButton118, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGap(20, 20, 20)
                                                                    .addComponent(jLabel30)))
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jLayeredPane5Layout.createSequentialGroup()
                                                                    .addGap(6, 6, 6)
                                                                    .addComponent(jLabel33)
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(jButton119, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane5Layout.createSequentialGroup()
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(jLabel31)
                                                                    .addGap(23, 23, 23)))
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jButton120, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane5Layout.createSequentialGroup()
                                                                    .addComponent(jLabel29)
                                                                    .addGap(22, 22, 22)))
                                                            .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jButton121, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane5Layout.createSequentialGroup()
                                                                    .addComponent(jLabel32)
                                                                    .addGap(25, 25, 25))))
                                                        .addComponent(jButton89, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            );
                                            jLayeredPane5.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton10, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton11, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton12, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton9, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton8, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton13, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton14, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton21, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton16, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton15, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton17, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton18, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton19, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton20, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton27, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton22, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton23, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton24, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton26, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton34, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton29, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton30, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton31, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton33, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton28, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton39, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton35, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton36, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton38, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton46, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton41, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton42, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton43, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton45, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton40, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton25, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton32, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton37, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton44, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton47, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton48, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton55, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton54, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton61, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton62, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton63, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton64, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton65, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton66, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton67, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton60, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton53, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton52, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton59, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton51, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton58, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton50, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton57real, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton49, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton56, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton68, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton69, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton70, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton71, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton72, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton73, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton74, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton75, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton76, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton77, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton78, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton79, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton80, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton81, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton82, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton83, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton84, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton85, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton86, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton87, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton88, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton89, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton90, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton91, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton92, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton93, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton94, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton95, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton96, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton97, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton98, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton99, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton100, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton101, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton102, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton103, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton104, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton105, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton106, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton107, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton108, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton109, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton110, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton111, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton112, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton113, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton114, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton115, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton116, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton117, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton118, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton119, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton120, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jButton121, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel22, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel23, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel24, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel25, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel26, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel27, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel28, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel29, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel30, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel31, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel32, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel33, javax.swing.JLayeredPane.DEFAULT_LAYER);
                                            jLayeredPane5.setLayer(jLabel34, javax.swing.JLayeredPane.DEFAULT_LAYER);

                                            jScrollPane1.setViewportView(jLayeredPane5);

                                            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/transcription/TTPictures/TopBar.png"))); // NOI18N

                                            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                                            getContentPane().setLayout(layout);
                                            layout.setHorizontalGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(65, 65, 65)
                                                    .addComponent(jLabel1))
                                            );
                                            layout.setVerticalGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE))
                                            );

                                            pack();
                                        }// </editor-fold>//GEN-END:initComponents

    /**
     * Listener for the clip if it's closed.
     */
    LineListener listener = new LineListener() {
        @Override
        public void update(LineEvent event) {
            if (event.getType() == STOP) {
                clip.close();
            }
        }

    };

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buttonNum = 0;
        buttonAction();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        buttonNum = 1;
        buttonAction();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        buttonNum = 2;
        buttonAction();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        buttonNum = 3;
        buttonAction();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        buttonNum = 4;
        buttonAction();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        buttonNum = 5;
        buttonAction();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        buttonNum = 6;
        buttonAction();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        buttonNum = 7;
        buttonAction();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        buttonNum = 8;
        buttonAction();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        buttonNum = 9;
        buttonAction();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        buttonNum = 10;
        buttonAction();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        buttonNum = 11;
        buttonAction();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        buttonNum = 12;
        buttonAction();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        buttonNum = 13;
        buttonAction();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        buttonNum = 14;
        buttonAction();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        buttonNum = 15;
        buttonAction();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        buttonNum = 16;
        buttonAction();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        buttonNum = 17;
        buttonAction();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        buttonNum = 18;
        buttonAction();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        buttonNum = 19;
        buttonAction();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        buttonNum = 20;
        buttonAction();
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        buttonNum = 21;
        buttonAction();
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        buttonNum = 22;
        buttonAction();
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        buttonNum = 23;
        buttonAction();
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        buttonNum = 24;
        buttonAction();
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        buttonNum = 25;
        buttonAction();
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        buttonNum = 26;
        buttonAction();
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        buttonNum = 27;
        buttonAction();
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        buttonNum = 28;
        buttonAction();
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        buttonNum = 29;
        buttonAction();
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        buttonNum = 30;
        buttonAction();
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        buttonNum = 31;
        buttonAction();
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        buttonNum = 32;
        buttonAction();
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        buttonNum = 33;
        buttonAction();
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        buttonNum = 34;
        buttonAction();
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        buttonNum = 35;
        buttonAction();
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        buttonNum = 36;
        buttonAction();
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        buttonNum = 37;
        buttonAction();
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        buttonNum = 38;
        buttonAction();
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        buttonNum = 39;
        buttonAction();
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        buttonNum = 40;
        buttonAction();
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        buttonNum = 41;
        buttonAction();
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        buttonNum = 42;
        buttonAction();
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        buttonNum = 43;
        buttonAction();
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        buttonNum = 44;
        buttonAction();
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        buttonNum = 45;
        buttonAction();
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        buttonNum = 46;
        buttonAction();
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        buttonNum = 47;
        buttonAction();
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        buttonNum = 48;
        buttonAction();
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        buttonNum = 49;
        buttonAction();
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        buttonNum = 50;
        buttonAction();
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        buttonNum = 51;
        buttonAction();
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        buttonNum = 52;
        buttonAction();
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        buttonNum = 53;
        buttonAction();
    }//GEN-LAST:event_jButton54ActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        buttonNum = 54;
        buttonAction();
    }//GEN-LAST:event_jButton55ActionPerformed

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        buttonNum = 55;
        buttonAction();
    }//GEN-LAST:event_jButton56ActionPerformed

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
        //don't do anything here, this button is not real and can't be removed
    }//GEN-LAST:event_jButton57ActionPerformed

    private void jButton57realActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57realActionPerformed
        buttonNum = 56;
        buttonAction();
    }//GEN-LAST:event_jButton57realActionPerformed

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        buttonNum = 57;
        buttonAction();
    }//GEN-LAST:event_jButton58ActionPerformed

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
        buttonNum = 58;
        buttonAction();
    }//GEN-LAST:event_jButton59ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        buttonNum = 59;
        buttonAction();
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        buttonNum = 60;
        buttonAction();
    }//GEN-LAST:event_jButton61ActionPerformed

    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        buttonNum = 61;
        buttonAction();
    }//GEN-LAST:event_jButton62ActionPerformed

    private void jButton63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton63ActionPerformed
        buttonNum = 62;
        buttonAction();
    }//GEN-LAST:event_jButton63ActionPerformed

    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
        buttonNum = 63;
        buttonAction();
    }//GEN-LAST:event_jButton64ActionPerformed

    private void jButton65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton65realActionPerformed
        buttonNum = 64;
        buttonAction();
    }//GEN-LAST:event_jButton65realActionPerformed

    private void jButton66ActionPerformed(java.awt.event.ActionEvent evt) {
        buttonNum = 65;
        buttonAction();
    }

    private void jButton67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton67ActionPerformed
        buttonNum = 66;
        buttonAction();
    }//GEN-LAST:event_jButton67ActionPerformed

    private void jButton68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton68ActionPerformed
        buttonNum = 67;
        buttonAction();
    }//GEN-LAST:event_jButton68ActionPerformed

    private void jButton69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton69ActionPerformed
        buttonNum = 68;
        buttonAction();
    }//GEN-LAST:event_jButton69ActionPerformed

    private void jButton70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton70ActionPerformed
        buttonNum = 69;
        buttonAction();
    }//GEN-LAST:event_jButton70ActionPerformed

    private void jButton71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton71ActionPerformed
        buttonNum = 70;
        buttonAction();
    }//GEN-LAST:event_jButton71ActionPerformed

    private void jButton72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton72ActionPerformed
        buttonNum = 71;
        buttonAction();
    }//GEN-LAST:event_jButton72ActionPerformed

    private void jButton73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton73ActionPerformed
        buttonNum = 72;
        buttonAction();
    }//GEN-LAST:event_jButton73ActionPerformed

    private void jButton74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton74ActionPerformed
        buttonNum = 73;
        buttonAction();
    }//GEN-LAST:event_jButton74ActionPerformed

    private void jButton75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton75ActionPerformed
        buttonNum = 74;
        buttonAction();
    }//GEN-LAST:event_jButton75ActionPerformed

    private void jButton76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton76ActionPerformed
        buttonNum = 75;
        buttonAction();
    }//GEN-LAST:event_jButton76ActionPerformed

    private void jButton77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton77ActionPerformed
        buttonNum = 76;
        buttonAction();
    }//GEN-LAST:event_jButton77ActionPerformed

    private void jButton78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton78ActionPerformed
        buttonNum = 77;
        buttonAction();
    }//GEN-LAST:event_jButton78ActionPerformed

    private void jButton79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton79ActionPerformed
        buttonNum = 78;
        buttonAction();
    }//GEN-LAST:event_jButton79ActionPerformed

    private void jButton80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton80ActionPerformed
        buttonNum = 79;
        buttonAction();
    }//GEN-LAST:event_jButton80ActionPerformed

    private void jButton81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton81ActionPerformed
        buttonNum = 80;
        buttonAction();
    }//GEN-LAST:event_jButton81ActionPerformed

    private void jButton82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton82ActionPerformed
        buttonNum = 81;
        buttonAction();
    }//GEN-LAST:event_jButton82ActionPerformed

    private void jButton83ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton83ActionPerformed
        buttonNum = 82;
        buttonAction();
    }//GEN-LAST:event_jButton83ActionPerformed

    private void jButton84ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton84ActionPerformed
        buttonNum = 83;
        buttonAction();
    }//GEN-LAST:event_jButton84ActionPerformed

    private void jButton85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton85ActionPerformed
        buttonNum = 84;
        buttonAction();
    }//GEN-LAST:event_jButton85ActionPerformed

    private void jButton86ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton86ActionPerformed
        buttonNum = 85;
        buttonAction();
    }//GEN-LAST:event_jButton86ActionPerformed

    private void jButton87ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton87ActionPerformed
        buttonNum = 86;
        buttonAction();
    }//GEN-LAST:event_jButton87ActionPerformed

    private void jButton88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton88ActionPerformed
        buttonNum = 87;
        buttonAction();
    }//GEN-LAST:event_jButton88ActionPerformed

    private void jButton89ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton89ActionPerformed
        buttonNum = 88;
        buttonAction();
    }//GEN-LAST:event_jButton89ActionPerformed

    private void jButton90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton90ActionPerformed
        buttonNum = 89;
        buttonAction();
    }//GEN-LAST:event_jButton90ActionPerformed

    private void jButton91ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton91ActionPerformed
        buttonNum = 90;
        buttonAction();
    }//GEN-LAST:event_jButton91ActionPerformed

    private void jButton92ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton92ActionPerformed
        buttonNum = 91;
        buttonAction();
    }//GEN-LAST:event_jButton92ActionPerformed

    private void jButton93ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton93ActionPerformed
        buttonNum = 92;
        buttonAction();
    }//GEN-LAST:event_jButton93ActionPerformed

    private void jButton94ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton94ActionPerformed
        buttonNum = 93;
        buttonAction();
    }//GEN-LAST:event_jButton94ActionPerformed

    private void jButton95ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton95ActionPerformed
        buttonNum = 94;
        buttonAction();
    }//GEN-LAST:event_jButton95ActionPerformed

    private void jButton96ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton96ActionPerformed
        buttonNum = 95;
        buttonAction();
    }//GEN-LAST:event_jButton96ActionPerformed

    private void jButton97ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton97ActionPerformed
        buttonNum = 96;
        buttonAction();
    }//GEN-LAST:event_jButton97ActionPerformed

    private void jButton98ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton98ActionPerformed
        buttonNum = 97;
        buttonAction();
    }//GEN-LAST:event_jButton98ActionPerformed

    private void jButton99ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton99ActionPerformed
        buttonNum = 98;
        buttonAction();
    }//GEN-LAST:event_jButton99ActionPerformed

    private void jButton100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton100ActionPerformed
        buttonNum = 99;
        buttonAction();
    }//GEN-LAST:event_jButton100ActionPerformed

    private void jButton101ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton101ActionPerformed
        buttonNum = 100;
        buttonAction();
    }//GEN-LAST:event_jButton101ActionPerformed

    private void jButton102ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton102ActionPerformed
        buttonNum = 101;
        buttonAction();
    }//GEN-LAST:event_jButton102ActionPerformed

    private void jButton103ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton103ActionPerformed
        buttonNum = 102;
        buttonAction();
    }//GEN-LAST:event_jButton103ActionPerformed

    private void jButton104ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton104ActionPerformed
        buttonNum = 103;
        buttonAction();
    }//GEN-LAST:event_jButton104ActionPerformed

    private void jButton105ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton105ActionPerformed
        buttonNum = 104;
        buttonAction();
    }//GEN-LAST:event_jButton105ActionPerformed

    private void jButton106ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton106ActionPerformed
        buttonNum = 105;
        buttonAction();
    }//GEN-LAST:event_jButton106ActionPerformed

    private void jButton107ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton107ActionPerformed
        buttonNum = 106;
        buttonAction();
    }//GEN-LAST:event_jButton107ActionPerformed

    private void jButton108ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton108ActionPerformed
        buttonNum = 107;
        buttonAction();
    }//GEN-LAST:event_jButton108ActionPerformed

    private void jButton109ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton109ActionPerformed
        buttonNum = 108;
        buttonAction();
    }//GEN-LAST:event_jButton109ActionPerformed

    private void jButton110ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton110ActionPerformed
        buttonNum = 109;
        buttonAction();
    }//GEN-LAST:event_jButton110ActionPerformed

    private void jButton111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton111ActionPerformed
        buttonNum = 110;
        buttonAction();
    }//GEN-LAST:event_jButton111ActionPerformed

    private void jButton112ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton112ActionPerformed
        buttonNum = 111;
        buttonAction();
    }//GEN-LAST:event_jButton112ActionPerformed

    private void jButton113ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton113ActionPerformed
        buttonNum = 112;
        buttonAction();
    }//GEN-LAST:event_jButton113ActionPerformed

    private void jButton114ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton114ActionPerformed
        buttonNum = 113;
        buttonAction();
    }//GEN-LAST:event_jButton114ActionPerformed

    private void jButton115ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton115ActionPerformed
        buttonNum = 114;
        buttonAction();
    }//GEN-LAST:event_jButton115ActionPerformed

    private void jButton116ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton116ActionPerformed
        buttonNum = 115;
        buttonAction();
    }//GEN-LAST:event_jButton116ActionPerformed

    private void jButton117ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton117ActionPerformed
        buttonNum = 116;
        buttonAction();
    }//GEN-LAST:event_jButton117ActionPerformed

    private void jButton118ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton118ActionPerformed
        buttonNum = 117;
        buttonAction();
    }//GEN-LAST:event_jButton118ActionPerformed

    private void jButton119ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton119ActionPerformed
        buttonNum = 118;
        buttonAction();
    }//GEN-LAST:event_jButton119ActionPerformed

    private void jButton120ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton120ActionPerformed
        buttonNum = 119;
        buttonAction();
    }//GEN-LAST:event_jButton120ActionPerformed

    private void jButton121ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton121ActionPerformed
        buttonNum = 120;
        buttonAction();
    }//GEN-LAST:event_jButton121ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ToneTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ToneTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ToneTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ToneTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ToneTable(path).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton100;
    private javax.swing.JButton jButton101;
    private javax.swing.JButton jButton102;
    private javax.swing.JButton jButton103;
    private javax.swing.JButton jButton104;
    private javax.swing.JButton jButton105;
    private javax.swing.JButton jButton106;
    private javax.swing.JButton jButton107;
    private javax.swing.JButton jButton108;
    private javax.swing.JButton jButton109;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton110;
    private javax.swing.JButton jButton111;
    private javax.swing.JButton jButton112;
    private javax.swing.JButton jButton113;
    private javax.swing.JButton jButton114;
    private javax.swing.JButton jButton115;
    private javax.swing.JButton jButton116;
    private javax.swing.JButton jButton117;
    private javax.swing.JButton jButton118;
    private javax.swing.JButton jButton119;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton120;
    private javax.swing.JButton jButton121;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton57real;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton72;
    private javax.swing.JButton jButton73;
    private javax.swing.JButton jButton74;
    private javax.swing.JButton jButton75;
    private javax.swing.JButton jButton76;
    private javax.swing.JButton jButton77;
    private javax.swing.JButton jButton78;
    private javax.swing.JButton jButton79;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton80;
    private javax.swing.JButton jButton81;
    private javax.swing.JButton jButton82;
    private javax.swing.JButton jButton83;
    private javax.swing.JButton jButton84;
    private javax.swing.JButton jButton85;
    private javax.swing.JButton jButton86;
    private javax.swing.JButton jButton87;
    private javax.swing.JButton jButton88;
    private javax.swing.JButton jButton89;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton90;
    private javax.swing.JButton jButton91;
    private javax.swing.JButton jButton92;
    private javax.swing.JButton jButton93;
    private javax.swing.JButton jButton94;
    private javax.swing.JButton jButton95;
    private javax.swing.JButton jButton96;
    private javax.swing.JButton jButton97;
    private javax.swing.JButton jButton98;
    private javax.swing.JButton jButton99;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
