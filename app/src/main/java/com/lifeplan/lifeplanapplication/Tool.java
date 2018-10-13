package com.lifeplan.lifeplanapplication;

public class Tool {

    /**
     * 文字列の引数を符号付き 10 進数の整数型として構文解析します。
     * 文字列が構文解析可能な int 値を含まない場合は、指定されたデフォルトの int 値を返します。
     *
     * @param value        構文解析対象の int 表現を含む String
     * @param defaultValue デフォルト値
     * @return 10 進数の引数で表される整数値
     */
    public static int parseInt(String value, int defaultValue) {

        try {
            // intに変換して返す
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            // デフォルト値を返す
            return defaultValue;
        }
    }
}
