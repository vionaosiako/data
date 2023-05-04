package com.example.data.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service

public class TopicService {
    @Autowired
    private TopicRepository topicRepositoty;
    private List<Topic> topics = Arrays.asList(
            new Topic("spring","spring framework","spring framework description"),
            new Topic("java","core java","java description"),
            new Topic("javascript","javascript framework","javascript framework description")
    );

    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<>();
        topicRepositoty.findAll()
        .forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }
    public void addTopic (Topic topic){

        topicRepositoty.save(topic);
    }

    public void updateTopic(String id, Topic topic){
        for(int i=0; i<topics.size(); i++){
            Topic t = topics.get(i);
            if (t.getId().equals(id)){
                topics.set(i ,topic);
                return;
            }
        }
    }

    public void deleteTopic(String id){
        topics.removeIf((t -> t.getId().equals(id)));
    }

}
