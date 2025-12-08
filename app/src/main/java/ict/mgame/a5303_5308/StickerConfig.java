package ict.mgame.a5303_5308;

public class StickerConfig {
    private final int widthDp;
    private final int heightDp;
    private final int marginStartDp;
    private final int marginTopDp;
    private final int marginEndDp;
    private final int marginBottomDp;

    // 我們使用 -1 作為預設值，表示不設定該邊距
    public StickerConfig(int widthDp, int heightDp, int marginStartDp, int marginTopDp, int marginEndDp, int marginBottomDp) {
        this.widthDp = widthDp;
        this.heightDp = heightDp;
        this.marginStartDp = marginStartDp;
        this.marginTopDp = marginTopDp;
        this.marginEndDp = marginEndDp;
        this.marginBottomDp = marginBottomDp;
    }

    // Getters
    public int getWidthDp() { return widthDp; }
    public int getHeightDp() { return heightDp; }
    public int getMarginStartDp() { return marginStartDp; }
    public int getMarginTopDp() { return marginTopDp; }
    public int getMarginEndDp() { return marginEndDp; }
    public int getMarginBottomDp() { return marginBottomDp; }
}