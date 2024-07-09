package com.kyong.suixianglu.g回溯算法;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/7/4 20:19
 */
//131.分割回文串
public class f分割回文串 {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> temp = new LinkedList<>();
    public List<List<String>> partition(String s) {
        if (StringUtils.isEmpty(s)) {
            return res;
        }
        back(s, 0);
        return res;
    }

    public void back(String s, int start) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(judge(s,start,i)){
                String str = s.substring(start, i + 1);
                temp.add(str);
            }else {
                continue;
            }
            back(s, i+1);
            temp.removeLast();
        }
    }

    public boolean judge(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
