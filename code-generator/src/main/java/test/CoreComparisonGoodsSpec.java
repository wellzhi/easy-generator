package test;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：质量问题模型
 *
 * @author Ay
 * @date 2017/05/03
 */
@Data
@Accessors(chain = true)
public class CoreComparisonGoodsSpec implements Serializable {

    /**
     *
     */
    private Long specId;
    /**
     *
     */
    private Long goodsId;
    /**
     *
     */
    private String title;
    /**
     * comparisonPropertyItem json数组
     */
    private String pvs;
    /**
     *
     */
    private String photoUrl;
    /**
     * 是否爆品
     */
    private Boolean hot;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private String creator;
    /**
     *
     */
    private Date updateTime;
    /**
     *
     */
    private String updater;
    /**
     *
     */
    private Boolean del;
    /**
     * 最后一次比价时间
     */
    private Date lastComparisonTime;

    /**
     * 总比价次数
     */

    public Long getSpecId() {
        return this.specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public Long getGoodsId() {
        return this.goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPvs() {
        return this.pvs;
    }

    public void setPvs(String pvs) {
        this.pvs = pvs;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Boolean getHot() {
        return this.hot;
    }

    public void setHot(Boolean hot) {
        this.hot = hot;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdater() {
        return this.updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Boolean getDel() {
        return this.del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    public Date getLastComparisonTime() {
        return this.lastComparisonTime;
    }

    public void setLastComparisonTime(Date lastComparisonTime) {
        this.lastComparisonTime = lastComparisonTime;
    }

}
