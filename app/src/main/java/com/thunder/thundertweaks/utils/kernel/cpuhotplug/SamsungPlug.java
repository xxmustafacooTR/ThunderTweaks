package com.thunder.thundertweaks.utils.kernel.cpuhotplug;

import android.content.Context;

import com.thunder.thundertweaks.fragments.ApplyOnBootFragment;
import com.thunder.thundertweaks.utils.Utils;
import com.thunder.thundertweaks.utils.root.Control;

/**
 * Created by Morogoku on 25/04/2017.
 */

public class SamsungPlug {

    private static final String HOTPLUG_SAMSUNG = "/sys/power/cpuhotplug";
	private static final String HOTPLUG_SAMSUNG_ENABLE = "/sys/power/cpuhotplug/enabled";
    private static final String HOTPLUG_SAMSUNG_LDSUM_ENABLE = "/sys/power/cpuhotplug/ldsum_enabled";
    private static final String HOTPLUG_SAMSUNG_SKIPLIT_ENABLE = "/sys/power/cpuhotplug/skip_lit_enabled";
    private static final String HOTPLUG_SAMSUNG_MODE = "/sys/power/cpuhotplug/user_mode";
    private static final String HOTPLUG_SAMSUNG_MAX_ONLINE_CPU = "/sys/power/cpuhotplug/max_online_cpu";
    private static final String HOTPLUG_SAMSUNG_MIN_ONLINE_CPU = "/sys/power/cpuhotplug/min_online_cpu";
    private static final String HOTPLUG_SAMSUNG_SINGLE_FREQ = "/sys/power/cpuhotplug/governor/single_freq";
    private static final String HOTPLUG_SAMSUNG_SINGLE_CHANGE_MS = "/sys/power/cpuhotplug/governor/single_change_ms";
    private static final String HOTPLUG_SAMSUNG_DUAL_CHANGE_MS = "/sys/power/cpuhotplug/governor/dual_change_ms";
    private static final String HOTPLUG_SAMSUNG_DUAL_FREQ = "/sys/power/cpuhotplug/governor/dual_freq";
    private static final String HOTPLUG_SAMSUNG_TRIPLE_CHANGE_MS = "/sys/power/cpuhotplug/governor/triple_change_ms";
    private static final String HOTPLUG_SAMSUNG_TRIPLE_FREQ = "/sys/power/cpuhotplug/governor/triple_freq";
    private static final String HOTPLUG_SAMSUNG_QUAD_CHANGE_MS = "/sys/power/cpuhotplug/governor/quad_change_ms";
    private static final String HOTPLUG_SAMSUNG_QUAD_FREQ = "/sys/power/cpuhotplug/governor/quad_freq";
    private static final String HOTPLUG_SAMSUNG_CL_BUSY_RATIO = "/sys/power/cpuhotplug/governor/cl_busy_ratio";
	private static final String HOTPLUG_SAMSUNG_LIT_MULT_RATIO = "/sys/power/cpuhotplug/governor/lit_mult_ratio";
	private static final String HOTPLUG_SAMSUNG_TO_DUAL_RATIO = "/sys/power/cpuhotplug/governor/to_dual_ratio";
	private static final String HOTPLUG_SAMSUNG_TO_QUAD_RATIO = "/sys/power/cpuhotplug/governor/to_quad_ratio";
	private static final String HOTPLUG_SAMSUNG_BIG_MODE_DUAL = "/sys/power/cpuhotplug/governor/big_mode_dual";
	private static final String HOTPLUG_SAMSUNG_BIG_MODE_NORMAL = "/sys/power/cpuhotplug/governor/big_mode_normal";

    public static void enableSamsungPlug(boolean enable, Context context) {
        run(Control.write(enable ? "1" : "0", HOTPLUG_SAMSUNG_ENABLE), HOTPLUG_SAMSUNG_ENABLE, context);
    }

    public static boolean isSamsungPlugEnabled() {
        return Utils.readFile(HOTPLUG_SAMSUNG_ENABLE).equals("1");
    }

    public static void enableLdsum(boolean enable, Context context) {
        run(Control.write(enable ? "1" : "0", HOTPLUG_SAMSUNG_LDSUM_ENABLE), HOTPLUG_SAMSUNG_LDSUM_ENABLE, context);
    }

    public static boolean isLdsumEnabled() {
        return Utils.readFile(HOTPLUG_SAMSUNG_LDSUM_ENABLE).equals("1");
    }

    public static void enableSkiplit(boolean enable, Context context) {
        run(Control.write(enable ? "1" : "0", HOTPLUG_SAMSUNG_SKIPLIT_ENABLE), HOTPLUG_SAMSUNG_SKIPLIT_ENABLE, context);
    }

    public static boolean isSkiplitEnabled() {
        return Utils.readFile(HOTPLUG_SAMSUNG_SKIPLIT_ENABLE).equals("1");
    }

    public static String getMaxOnlineCpu() {
        String value = Utils.readFile(HOTPLUG_SAMSUNG_MAX_ONLINE_CPU);
        if (!value.isEmpty()) {
            return value.replace("max online cpu : ", "");
        }
        return null;
    }

    public static void setMaxOnlineCpu(int value, Context context) {
        run(Control.write(String.valueOf(value), HOTPLUG_SAMSUNG_MAX_ONLINE_CPU), HOTPLUG_SAMSUNG_MAX_ONLINE_CPU, context);
    }

    public static String getMinOnlineCpu() {
        String value = Utils.readFile(HOTPLUG_SAMSUNG_MIN_ONLINE_CPU);
        if (!value.isEmpty()) {
            return value.replace("min online cpu : ", "");
        }
        return null;
    }

    public static void setMinOnlineCpu(int value, Context context) {
        run(Control.write(String.valueOf(value), HOTPLUG_SAMSUNG_MIN_ONLINE_CPU), HOTPLUG_SAMSUNG_MIN_ONLINE_CPU, context);
    }

    public static String getSingleChangeMs(){
        return Utils.readFile(HOTPLUG_SAMSUNG_SINGLE_CHANGE_MS);
    }

    public static void setSingleChangeMs(int value, Context context){
        run(Control.write(String.valueOf(value), HOTPLUG_SAMSUNG_SINGLE_CHANGE_MS), HOTPLUG_SAMSUNG_SINGLE_CHANGE_MS, context);
    }

    public static boolean hasSingleChangeMs() {
        return Utils.existFile(HOTPLUG_SAMSUNG_SINGLE_CHANGE_MS);
    }

    public static String getDualChangeMs(){
        return Utils.readFile(HOTPLUG_SAMSUNG_DUAL_CHANGE_MS);
    }

    public static void setDualChangeMs(int value, Context context){
        run(Control.write(String.valueOf(value), HOTPLUG_SAMSUNG_DUAL_CHANGE_MS), HOTPLUG_SAMSUNG_DUAL_CHANGE_MS, context);
    }

    public static boolean hasDualChangeMs() {
        return Utils.existFile(HOTPLUG_SAMSUNG_DUAL_CHANGE_MS);
    }

    public static String getTripleChangeMs(){
        return Utils.readFile(HOTPLUG_SAMSUNG_TRIPLE_CHANGE_MS);
    }

    public static void setTripleChangeMs(int value, Context context){
        run(Control.write(String.valueOf(value), HOTPLUG_SAMSUNG_TRIPLE_CHANGE_MS), HOTPLUG_SAMSUNG_TRIPLE_CHANGE_MS, context);
    }

    public static boolean hasTripleChangeMs() {
        return Utils.existFile(HOTPLUG_SAMSUNG_TRIPLE_CHANGE_MS);
    }

    public static String getQuadChangeMs(){
        return Utils.readFile(HOTPLUG_SAMSUNG_QUAD_CHANGE_MS);
    }

    public static void setQuadChangeMs(int value, Context context){
        run(Control.write(String.valueOf(value), HOTPLUG_SAMSUNG_QUAD_CHANGE_MS), HOTPLUG_SAMSUNG_QUAD_CHANGE_MS, context);
    }

    public static boolean hasQuadChangeMs() {
        return Utils.existFile(HOTPLUG_SAMSUNG_QUAD_CHANGE_MS);
    }

    public static void setCpuSingle(int value, Context context) {
        run(Control.write(String.valueOf(value), HOTPLUG_SAMSUNG_SINGLE_FREQ),
                HOTPLUG_SAMSUNG_SINGLE_FREQ, context);
    }

    public static int getCpuSingle() {
        return Utils.strToInt(Utils.readFile(HOTPLUG_SAMSUNG_SINGLE_FREQ));
    }

    public static boolean hasCpuSingle() {
        return Utils.existFile(HOTPLUG_SAMSUNG_SINGLE_FREQ);
    }

    public static void setCpuDual(int value, Context context) {
        run(Control.write(String.valueOf(value), HOTPLUG_SAMSUNG_DUAL_FREQ),
                HOTPLUG_SAMSUNG_DUAL_FREQ, context);
    }

    public static int getCpuDual() {
        return Utils.strToInt(Utils.readFile(HOTPLUG_SAMSUNG_DUAL_FREQ));
    }

    public static boolean hasCpuDual() {
        return Utils.existFile(HOTPLUG_SAMSUNG_DUAL_FREQ);
    }

    public static void setCpuTriple(int value, Context context) {
        run(Control.write(String.valueOf(value), HOTPLUG_SAMSUNG_TRIPLE_FREQ),
                HOTPLUG_SAMSUNG_TRIPLE_FREQ, context);
    }

    public static int getCpuTriple() {
        return Utils.strToInt(Utils.readFile(HOTPLUG_SAMSUNG_TRIPLE_FREQ));
    }

    public static boolean hasCpuTriple() {
        return Utils.existFile(HOTPLUG_SAMSUNG_TRIPLE_FREQ);
    }
    public static void setCpuQuad(int value, Context context) {
        run(Control.write(String.valueOf(value), HOTPLUG_SAMSUNG_QUAD_FREQ),
                HOTPLUG_SAMSUNG_QUAD_FREQ, context);
    }

    public static int getCpuQuad() {
        return Utils.strToInt(Utils.readFile(HOTPLUG_SAMSUNG_QUAD_FREQ));
    }

    public static boolean hasCpuQuad() {
        return Utils.existFile(HOTPLUG_SAMSUNG_QUAD_FREQ);
    }

    public static String getUserMode(){
        return Utils.readFile(HOTPLUG_SAMSUNG_MODE);
    }

    public static void setUserMode(int value, Context context){
        run(Control.write(String.valueOf(value), HOTPLUG_SAMSUNG_MODE), HOTPLUG_SAMSUNG_MODE, context);
    }

    public static String getLitMultRatio(){
        return Utils.readFile(HOTPLUG_SAMSUNG_LIT_MULT_RATIO);
    }

    public static void setLitMultRatio(int value, Context context){
        run(Control.write(String.valueOf(value), HOTPLUG_SAMSUNG_LIT_MULT_RATIO), HOTPLUG_SAMSUNG_LIT_MULT_RATIO, context);
    }

    public static boolean hasLitMultRatio() {
        return Utils.existFile(HOTPLUG_SAMSUNG_LIT_MULT_RATIO);
    }

    public static String getClBusyRatio(){
        return Utils.readFile(HOTPLUG_SAMSUNG_CL_BUSY_RATIO);
    }

    public static void setClBusyRatio(int value, Context context){
        run(Control.write(String.valueOf(value), HOTPLUG_SAMSUNG_CL_BUSY_RATIO), HOTPLUG_SAMSUNG_CL_BUSY_RATIO, context);
    }

    public static boolean hasClBusyRatio() {
        return Utils.existFile(HOTPLUG_SAMSUNG_CL_BUSY_RATIO);
    }

    public static String getToDualRatio(){
        return Utils.readFile(HOTPLUG_SAMSUNG_TO_DUAL_RATIO);
    }

    public static void setToDualRatio(int value, Context context){
        run(Control.write(String.valueOf(value), HOTPLUG_SAMSUNG_TO_DUAL_RATIO), HOTPLUG_SAMSUNG_TO_DUAL_RATIO, context);
    }

    public static boolean hasToDualRatio() {
        return Utils.existFile(HOTPLUG_SAMSUNG_TO_DUAL_RATIO);
    }

    public static String getToQuadRatio(){
        return Utils.readFile(HOTPLUG_SAMSUNG_TO_QUAD_RATIO);
    }

    public static void setToQuadRatio(int value, Context context){
        run(Control.write(String.valueOf(value), HOTPLUG_SAMSUNG_TO_QUAD_RATIO), HOTPLUG_SAMSUNG_TO_QUAD_RATIO, context);
    }

    public static boolean hasToQuadRatio() {
        return Utils.existFile(HOTPLUG_SAMSUNG_TO_QUAD_RATIO);
    }

    public static String getBigModeDual(){
        return Utils.readFile(HOTPLUG_SAMSUNG_BIG_MODE_DUAL);
    }

    public static void setBigModeDual(int value, Context context){
        run(Control.write(String.valueOf(value), HOTPLUG_SAMSUNG_BIG_MODE_DUAL), HOTPLUG_SAMSUNG_BIG_MODE_DUAL, context);
    }

    public static boolean hasBigModeDual() {
        return Utils.existFile(HOTPLUG_SAMSUNG_BIG_MODE_DUAL);
    }

    public static String getBigModeNormal(){
		return Utils.readFile(HOTPLUG_SAMSUNG_BIG_MODE_NORMAL);
    }

    public static void setBigModeNormal(int value, Context context){
        run(Control.write(String.valueOf(value), HOTPLUG_SAMSUNG_BIG_MODE_NORMAL), HOTPLUG_SAMSUNG_BIG_MODE_NORMAL, context);
    }

    public static boolean hasBigModeNormal() {
        return Utils.existFile(HOTPLUG_SAMSUNG_BIG_MODE_NORMAL);
    }

    public static boolean supported() {
        return Utils.existFile(HOTPLUG_SAMSUNG);
    }

    private static void run(String command, String id, Context context) {
        Control.runSetting(command, ApplyOnBootFragment.CPU_HOTPLUG, id, context);
    }
}
