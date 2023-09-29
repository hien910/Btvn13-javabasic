package constant;

public enum Type {
    CA_NHAN("CÁ NHÂN"),
    DAI_DIEN_DON_VI_KINH_DOANH("ĐẠI DIỆN ĐƠN VỊ KINH DOANH"),
    DAI_DIEN_DON_VI_HANH_CHINH("ĐẠI DIỆN ĐƠN VỊ HÀNH CHÍNH");
    public String value;

    Type(String value) { this.value=value;
    }
}
