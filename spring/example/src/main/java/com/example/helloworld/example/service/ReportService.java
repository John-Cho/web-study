package com.example.helloworld.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.helloworld.example.dto.Item;
import com.example.helloworld.example.dto.UserData;

@Service
public class ReportService {
    /* 사용자 별 일기 저장소 */
    private ArrayList<UserData> db = new ArrayList<UserData>();

    /* User 가 작성한 일기 불러오기 */
    public UserData getUserData(String name){
        UserData ret = new UserData("", null);

        db.forEach((user)->{
            if(user.getName().equals(name)){
                ret.setName(user.getName());
                ret.setData(user.getData());
            }
        });

        if(ret.getData() == null){
            return null;
        }
        else{
            return ret;
        }
    }

    /* User 가 작성한 일기 저장 */
    public UserData setUserData(String name, Item item){
        UserData ret = new UserData("", null);

        db.forEach((user)->{
            if(user.getName().equals(name)){
                ArrayList<Item> items = user.getData();
                items.add(item);

                ret.setName(user.getName());
                ret.setData(user.getData());
            }
        });

        if(ret.getData() == null){
            ArrayList<Item> items = new ArrayList<>();
            items.add(item);

            ret.setName(name);
            ret.setData(items);
            db.add(ret);

            return ret;
        }
        else{
            return ret;
        }
    }
}
