package ${package_name}.model;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

/**
* 描述：${table_annotation}模型
* @author ${author}
* @date ${date}
*/
@Data
@Accessors(chain = true)
public class ${table_name} implements Serializable {

<#if model_column?exists>
    <#list model_column as model>
        /**
        * ${model.columnComment!}
        */
        <#if (model.columnType == 'VARCHAR'|| model.columnType == 'TEXT')>
            private String ${model.changeColumnName?uncap_first};
        </#if>
        <#if model.columnType == 'TIMESTAMP' || model.columnType == 'DATETIME'>
            private Date ${model.changeColumnName?uncap_first};
        </#if>
        <#if model.columnType == 'INTEGER'>
            private Integer ${model.changeColumnName?uncap_first};
        </#if>
        <#if model.columnType == 'BIGINT'>
            private Long ${model.changeColumnName?uncap_first};
        </#if>
        <#if model.columnType == 'BIT'>
            private Boolean ${model.changeColumnName?uncap_first};
        </#if>
    </#list>
</#if>

<#if model_column?exists>
    <#list model_column as model>
        <#if (model.columnType == 'VARCHAR' || model.columnType == 'TEXT')>
            public String get${model.changeColumnName}() {
            return this.${model.changeColumnName?uncap_first};
            }

            public void set${model.changeColumnName}(String ${model.changeColumnName?uncap_first}) {
            this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
            }
        </#if>
        <#if model.columnType == 'TIMESTAMP'  || model.columnType == 'DATETIME'>
            public Date get${model.changeColumnName}() {
            return this.${model.changeColumnName?uncap_first};
            }

            public void set${model.changeColumnName}(Date ${model.changeColumnName?uncap_first}) {
            this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
            }
        </#if>
        <#if model.columnType == 'INTEGER' >
            public Integer get${model.changeColumnName}() {
            return this.${model.changeColumnName?uncap_first};
            }

            public void set${model.changeColumnName}(Integer ${model.changeColumnName?uncap_first}) {
            this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
            }
        </#if>
        <#if model.columnType == 'BIGINT' >
            public Long get${model.changeColumnName}() {
            return this.${model.changeColumnName?uncap_first};
            }

            public void set${model.changeColumnName}(Long ${model.changeColumnName?uncap_first}) {
            this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
            }
        </#if>
        <#if model.columnType == 'BIT' >
            public Boolean get${model.changeColumnName}() {
            return this.${model.changeColumnName?uncap_first};
            }

            public void set${model.changeColumnName}(Boolean ${model.changeColumnName?uncap_first}) {
            this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
            }
        </#if>
    </#list>
</#if>

}
