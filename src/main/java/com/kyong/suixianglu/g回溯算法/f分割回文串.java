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
        if (StringUtils.isEmpty(s)){
            return res;
        }

        return res;
    }

    public void back(String s, int start, int len){
        if(start + len == s.length()) {
            res.add(temp);
            return;
        }
        for (int i = len+start; i < s.length(); i++) {
            boolean flag = false;
            String substring = s.substring(start, i);
            String reverse = StringUtils.reverse(substring);
            if(!substring.equals(reverse)){
                back(s,i,len++);
            }
            temp.add(s.substring(start, i));

            temp.removeLast();

        }


    }

}
