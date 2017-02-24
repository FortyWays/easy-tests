package easytests.mappers;

import easytests.entities.IssueStandardTopicPriority;
import easytests.entities.IssueStandardTopicPriorityInterface;
import java.util.List;
import org.apache.ibatis.annotations.*;

/**
 * @author SingularityA
 */
@Mapper
public interface IssueStandardTopicPriorityMapper {

    @Results(
        id = "IssueStandardTopicPriority",
        value = {
            @Result(property = "id", column = "id"),
            @Result(property = "topicId", column = "topic_id"),
                // TODO: javaType for Enum (Priority)
            @Result(property = "priority", column = "priority"),
            @Result(property = "issueStandardId", column = "issue_standard_id")
        })
    @Select("SELECT * FROM topic_priorities")
    List<IssueStandardTopicPriority> findAll();

    @Select("SELECT * FROM topic_priorities WHERE id=#{id}")
    @ResultMap("IssueStandardTopicPriority")
    IssueStandardTopicPriority find(Integer id);

    @Select("SELECT * FROM topic_priorities WHERE issue_standard_id=#{issueStandardId}")
    @ResultMap("IssueStandardTopicPriority")
    List<IssueStandardTopicPriority> findByIssueStandardId(Integer issueStandardId);

    @Insert("INSERT INTO topic_priorities (topic_id, priority, issue_standard_id)"
            + " VALUES (#{topicId}, #{priority}, #{issueStandardId}")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void insert(IssueStandardTopicPriorityInterface issueStandardTopicPriority);

    @Update("UPDATE topic_priorities"
            + " SET topic_id=#{topicId}, priority=#{priority}, issue_standard_id=#{issueStandardId}")
    void update(IssueStandardTopicPriorityInterface issueStandardTopicPriority);

    @Delete("DELETE FROM topic_priorities WHERE id=#{id}")
    void delete(IssueStandardTopicPriorityInterface issueStandardTopicPriority);
}
