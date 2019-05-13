package com.qhit.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RegexUtils {
    /**
     * 验证Email
     * @param email email地址，格式：zhangsan@zuidaima.com，zhangsan@xxx.com.cn，xxx代表邮件服务商
     * @return 验证成功返回true，验证失败返回false
     */
    public boolean checkEmail(String email) {
        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
        return Pattern.matches(regex, email);
    }
//
//    /**
//     * 验证身份证号码
//     * @param idCard 居民身份证号码15位或18位，最后一位可能是数字或字母
//     * @return 验证成功返回true，验证失败返回false
//     */
//    public boolean checkIdCard(String idCard) {
//        String regex = "[1-9]\\d{13,16}[a-zA-Z0-9]{1}";
//        return Pattern.matches(regex,idCard);
//    }
//
    /**
     * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
     * @param mobile 移动、联通、电信运营商的号码段
     *<p>移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡）
     *、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）</p>
     *<p>联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）</p>
     *<p>电信的号段：133、153、180（未启用）、189</p>
     * @return 验证成功返回true，验证失败返回false
     */
    public boolean checkMobile(String mobile) {
        String regex = "(\\+\\d+)?1[34578]\\d{9}$";
        return Pattern.matches(regex,mobile);
    }
//
//    /**
//     * 验证固定电话号码
//     * @param phone 电话号码，格式：国家（地区）电话代码 + 区号（城市代码） + 电话号码，如：+8602085588447
//     * <p><b>国家（地区） 代码 ：</b>标识电话号码的国家（地区）的标准国家（地区）代码。它包含从 0 到 9 的一位或多位数字，
//     *  数字之后是空格分隔的国家（地区）代码。</p>
//     * <p><b>区号（城市代码）：</b>这可能包含一个或多个从 0 到 9 的数字，地区或城市代码放在圆括号——
//     * 对不使用地区或城市代码的国家（地区），则省略该组件。</p>
//     * <p><b>电话号码：</b>这包含从 0 到 9 的一个或多个数字 </p>
//     * @return 验证成功返回true，验证失败返回false
//     */
//    public boolean checkPhone(String phone) {
//        String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";
//        return Pattern.matches(regex, phone);
//    }
//
//    /**
//     * 验证整数（正整数和负整数）
//     * @param digit 一位或多位0-9之间的整数
//     * @return 验证成功返回true，验证失败返回false
//     */
//    public boolean checkDigit(String digit) {
//        String regex = "\\-?[1-9]\\d+";
//        return Pattern.matches(regex,digit);
//    }
//
//    /**
//     * 验证整数和浮点数（正负整数和正负浮点数）
//     * @param decimals 一位或多位0-9之间的浮点数，如：1.23，233.30
//     * @return 验证成功返回true，验证失败返回false
//     */
//    public boolean checkDecimals(String decimals) {
//        String regex = "\\-?[1-9]\\d+(\\.\\d+)?";
//        return Pattern.matches(regex,decimals);
//    }
//
//    /**
//     * 验证空白字符
//     * @param blankSpace 空白字符，包括：空格、\t、\n、\r、\f、\x0B
//     * @return 验证成功返回true，验证失败返回false
//     */
//    public boolean checkBlankSpace(String blankSpace) {
//        String regex = "\\s+";
//        return Pattern.matches(regex,blankSpace);
//    }
//
    /**
     * 验证中文
     * @param chinese 中文字符
     * @return 验证成功返回true，验证失败返回false
     */
    public boolean checkChinese(String chinese) {
        String regex = "^[\u4E00-\u9FA5]+$";
        return Pattern.matches(regex,chinese);
    }
//
//    /**
//     * 验证日期（年月日）
//     * @param birthday 日期，格式：1992-09-03，或1992.09.03
//     * @return 验证成功返回true，验证失败返回false
//     */
//    public boolean checkBirthday(String birthday) {
//        String regex = "[1-9]{4}([-./])\\d{1,2}\\1\\d{1,2}";
//        return Pattern.matches(regex,birthday);
//    }
//
//    /**
//     * 验证URL地址
//     * @param url 格式：http://blog.csdn.net:80/xyang81/article/details/7705960? 或 http://www.csdn.net:80
//     * @return 验证成功返回true，验证失败返回false
//     */
//    public boolean checkURL(String url) {
//        String regex = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";
//        return Pattern.matches(regex, url);
//    }
//
//    /**
//     * <pre>
//     * 获取网址 URL 的一级域
//     * </pre>
//     *
//     * @param url
//     * @return
//     */
//    public String getDomain(String url) {
//        Pattern p = Pattern.compile("(?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);
//        // 获取完整的域名
//        // Pattern p=Pattern.compile("[^//]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);
//        Matcher matcher = p.matcher(url);
//        matcher.find();
//        return matcher.group();
//    }
//    /**
//     * 匹配中国邮政编码
//     * @param postcode 邮政编码
//     * @return 验证成功返回true，验证失败返回false
//     */
//    public boolean checkPostcode(String postcode) {
//        String regex = "[1-9]\\d{5}";
//        return Pattern.matches(regex, postcode);
//    }
//
//    /**
//     * 匹配IP地址(简单匹配，格式，如：192.168.1.1，127.0.0.1，没有匹配IP段的大小)
//     * @param ipAddress IPv4标准地址
//     * @return 验证成功返回true，验证失败返回false
//     */
//    public boolean checkIpAddress(String ipAddress) {
//        String regex = "[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))";
//        return Pattern.matches(regex, ipAddress);
//    }
    /**
     * 正则：身份证号码15位
     */
    public final String REGEX_ID_CARD15     = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$";
    /**
     * 正则：身份证号码18位
     */
    public final String REGEX_ID_CARD18     = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9Xx])$";
    /**
     * 正则：邮箱
     */
    public final String REGEX_EMAIL         = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    /**
     * 正则：URL
     */
    public final String REGEX_URL           = "[a-zA-z]+://[^\\s]*";
    /**
     * 正则：汉字
     */
    public final String REGEX_ZH            = "^[\\u4e00-\\u9fa5]+$";
    /**
     * 正则：用户名，取值范围为a-z,A-Z,0-9,"_",汉字，不能以"_"结尾,用户名必须是6-20位
     */
    public final String REGEX_USERNAME      = "^[\\w\\u4e00-\\u9fa5]{6,20}(?<!_)$";
    /**
     * 正则：yyyy-MM-dd格式的日期校验，已考虑平闰年
     */
    public final String REGEX_DATE          = "^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$";
    /**
     * 正则：IP地址
     */
    public final String REGEX_IP            = "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";

/************** 以下摘自http://tool.oschina.net/regex **************/

    /**
     * 正则：双字节字符(包括汉字在内)
     */
    public final String REGEX_DOUBLE_BYTE_CHAR     = "[^\\x00-\\xff]";
    /**
     * 正则：空白行
     */
    public final String REGEX_BLANK_LINE           = "\\n\\s*\\r";
    /**
     * 正则：QQ号
     */
    public final String REGEX_TENCENT_NUM          = "[1-9][0-9]{4,}";
    /**
     * 正则：中国邮政编码
     */
    public final String REGEX_ZIP_CODE             = "[1-9]\\d{5}(?!\\d)";
    /**
     * 正则：正整数
     */
    public final String REGEX_POSITIVE_INTEGER     = "^[1-9]\\d*$";
    /**
     * 正则：负整数
     */
    public final String REGEX_NEGATIVE_INTEGER     = "^-[1-9]\\d*$";
    /**
     * 正则：整数
     */
    public final String REGEX_INTEGER              = "^-?[1-9]\\d*$";
    /**
     * 正则：非负整数(正整数 + 0)
     */
    public final String REGEX_NOT_NEGATIVE_INTEGER = "^[1-9]\\d*|0$";
    /**
     * 正则：非正整数（负整数 + 0）
     */
    public final String REGEX_NOT_POSITIVE_INTEGER = "^-[1-9]\\d*|0$";
    /**
     * 正则：正浮点数
     */
    public final String REGEX_POSITIVE_FLOAT       = "^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$";
    /**
     * 正则：负浮点数
     */
    public final String REGEX_NEGATIVE_FLOAT       = "^-[1-9]\\d*\\.\\d*|-0\\.\\d*[1-9]\\d*$";
//
//    /**
//     * 正则：只有数字
//     */
//    public final String REGEX_NUMBER               = "[0-9]*";
//
//    public RegexUtils() {
//        throw new UnsupportedOperationException("u can't instantiate me...");
//    }
//
//    /**
//     * 验证是否只有数字
//     * @param input 待验证文本
//     * @return {@code true}: 匹配<br>{@code false}: 不匹配
//     */
////    public static boolean isNumeric(CharSequence input) {
////        return isMatch(REGEX_NUMBER, input);
////    }
//
//
//    /**
//     * If u want more please visit http://toutiao.com/i6231678548520731137/
//     */
//
//    /**
//     * 验证手机号（简单）
//     *
//     * @param input 待验证文本
//     * @return {@code true}: 匹配<br>{@code false}: 不匹配
//     */
////    public static boolean isMobileSimple(CharSequence input) {
////        return isMatch(REGEX_MOBILE_SIMPLE, input);
////    }
//
//
//
//    /**
//     * 验证手机号（精确）
//     *
//     * @param input 待验证文本
//     * @return {@code true}: 匹配<br>{@code false}: 不匹配
//     */
////    public static boolean isMobileExact(CharSequence input) {
////        return isMatch(REGEX_MOBILE_EXACT, input);
////    }
//
//    /**
//     * 验证电话号码
//     *
//     * @param input 待验证文本
//     * @return {@code true}: 匹配<br>{@code false}: 不匹配
//     */
////    public static boolean isTel(CharSequence input) {
////        return isMatch(REGEX_TEL, input);
////    }
//
//    /**
//     * 验证身份证号码15位
//     *
//     * @param input 待验证文本
//     * @return {@code true}: 匹配<br>{@code false}: 不匹配
//     */
////    public static boolean isIDCard15(CharSequence input) {
////        return isMatch(REGEX_ID_CARD15, input);
////    }
//
//    /**
//     * 验证身份证号码18位
//     *
//     * @param input 待验证文本
//     * @return {@code true}: 匹配<br>{@code false}: 不匹配
//     */
////    public static boolean isIDCard18(CharSequence input) {
////        return isMatch(REGEX_ID_CARD18, input);
////    }
//
//    /**
//     * 验证邮箱
//     *
//     * @param input 待验证文本
//     * @return {@code true}: 匹配<br>{@code false}: 不匹配
//     */
////    public static boolean isEmail(CharSequence input) {
////        return isMatch(REGEX_EMAIL, input);
////    }
//
//    /**
//     * 验证URL
//     *
//     * @param input 待验证文本
//     * @return {@code true}: 匹配<br>{@code false}: 不匹配
//     */
////    public static boolean isURL(CharSequence input) {
////        return isMatch(REGEX_URL, input);
////    }
//
//    /**
//     * 验证汉字
//     *
//     * @param input 待验证文本
//     * @return {@code true}: 匹配<br>{@code false}: 不匹配
//     */
////    public static boolean isZh(CharSequence input) {
////        return isMatch(REGEX_ZH, input);
////    }
//
    /**
     * 验证用户名
     * <p>取值范围为a-z,A-Z,0-9,"_",汉字，不能以"_"结尾,用户名必须是6-20位</p>
     *
     * @param input 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
//    public static boolean isUsername(CharSequence input) {
//        return isMatch(REGEX_USERNAME, input);
//    }
//
//    /**
//     * 验证yyyy-MM-dd格式的日期校验，已考虑平闰年
//     *
//     * @param input 待验证文本
//     * @return {@code true}: 匹配<br>{@code false}: 不匹配
//     */
////    public static boolean isDate(CharSequence input) {
////        return isMatch(REGEX_DATE, input);
////    }
//
//    /**
//     * 验证IP地址
//     *
//     * @param input 待验证文本
//     * @return {@code true}: 匹配<br>{@code false}: 不匹配
//     */
////    public static boolean isIP(CharSequence input) {
////        return isMatch(REGEX_IP, input);
////    }
//
//    /**
//     * 判断是否匹配正则
//     *
//     * @param regex 正则表达式
//     * @param input 要匹配的字符串
//     * @return {@code true}: 匹配<br>{@code false}: 不匹配
//     */
//    public boolean isMatch(String regex, CharSequence input) {
//        return input != null && input.length() > 0 && Pattern.matches(regex, input);
//    }
//
//    /**
//     * 获取正则匹配的部分
//     *
//     * @param regex 正则表达式
//     * @param input 要匹配的字符串
//     * @return 正则匹配的部分
//     */
//    public List<String> getMatches(String regex, CharSequence input) {
//        if (input == null) return null;
//        List<String> matches = new ArrayList<>();
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(input);
//        while (matcher.find()) {
//            matches.add(matcher.group());
//        }
//        return matches;
//    }
//
//    /**
//     * 获取正则匹配分组
//     *
//     * @param input 要分组的字符串
//     * @param regex 正则表达式
//     * @return 正则匹配分组
//     */
//    public String[] getSplits(String input, String regex) {
//        if (input == null) return null;
//        return input.split(regex);
//    }
//
//    /**
//     * 替换正则匹配的第一部分
//     *
//     * @param input       要替换的字符串
//     * @param regex       正则表达式
//     * @param replacement 代替者
//     * @return 替换正则匹配的第一部分
//     */
//    public String getReplaceFirst(String input, String regex, String replacement) {
//        if (input == null) return null;
//        return Pattern.compile(regex).matcher(input).replaceFirst(replacement);
//    }
//
//    /**
//     * 替换所有正则匹配的部分
//     *
//     * @param input       要替换的字符串
//     * @param regex       正则表达式
//     * @param replacement 代替者
//     * @return 替换所有正则匹配的部分
//     */
//    public String getReplaceAll(String input, String regex, String replacement) {
//        if (input == null) return null;
//        return Pattern.compile(regex).matcher(input).replaceAll(replacement);
//    }
}
