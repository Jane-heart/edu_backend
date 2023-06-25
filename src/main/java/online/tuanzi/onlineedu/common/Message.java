package online.tuanzi.onlineedu.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: Tuanzi
 * @Description: websocket聊天实体，此时仅考虑文本消息，不考虑表情视频图片等情况
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String id;//消息id
    private String fromId;
    private String toId;
    private String content;//内容
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;//发送时间
}
