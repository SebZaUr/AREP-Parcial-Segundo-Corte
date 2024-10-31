package arep.parcial.mathservice;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MathService {

    public Integer linealSearch(Integer[] list,  Integer value){
        for(int i =0; i< list.length; i++){
            if(value.equals(list[i])){
                return i;
            }
        }
        return -1;
    }

    public  Integer binarySearch(Integer[] list,Integer value){
        int index = list.length/2;
        int answer = -1;
        int divide = 0;
        if(Objects.equals(list[index], value)){
            answer = index;
        }else if(list[index] < value){
            divide++;
            answer = binarySearch(generateList(index, list.length, list), value);
        }else if(list[index]> value){
            divide++;
            answer = binarySearch(generateList(0,index,list), value);
        }
        if(answer != -1){
            answer = answer + divide + 1;
        }
        return answer;
    }

    private Integer[] generateList(Integer start,Integer finish,Integer[] list){
        List<Integer> newList = new ArrayList<>();
        for(int i = start;i<finish;i++){
            newList.add(list[i]);
        }
        return newList.toArray(new Integer[0]);
    }
}
