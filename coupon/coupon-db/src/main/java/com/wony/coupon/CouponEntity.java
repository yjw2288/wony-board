package com.wony.coupon;

import com.wony.coupon.category.CouponCategoryEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "coupon")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(of = "couponId")
public class CouponEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "couponId")
    private long couponId;

    @Column(name = "coupon_name", nullable = false)
    private String couponName;

    @Column(name = "shop_name", nullable = false)
    private String shopName;

    @Column(name = "coupon_image", nullable = false)
    private String couponImage;

    @Column(name = "contents", nullable = false)
    private String contents;

    @Column(name = "banner_image", nullable = false)
    private String bannerImage;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "discount_rate", nullable = false)
    private int discountRate;

    @Column(name = "discount_money", nullable = false)
    private int discountMoney;

    @Column(name = "download_count", nullable = false)
    private long downloadCount;

    @Column(name = "link_click_count", nullable = false)
    private long linkClickCount;

    @Column(name = "download_available_count", nullable = false)
    private long downloadAvailableCount;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "download_count_limit", nullable = false)
    private long downloadCountLimit;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "enable", nullable = false)
    private boolean enable;

    @Column(name = "created_date", nullable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "modified_date", nullable = false)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_category_id", nullable = false)
    private CouponCategoryEntity couponCategory;

    @Column(name = "contents_provider_id", nullable = false)
    private long contentsProviderId;

    public boolean canUse() {
        Date now = new Date();
        return enable
                && startDate.before(now)
                && endDate.after(now);
    }

}
