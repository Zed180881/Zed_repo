package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.CommodityStatus;
import ua.service.CommodityStatusService;

public class CommodityStatusEditor extends PropertyEditorSupport {

    private final CommodityStatusService commodityStatusService;

    public CommodityStatusEditor(CommodityStatusService commodityStatusService) {
	this.commodityStatusService = commodityStatusService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
	CommodityStatus commodityStatus = commodityStatusService
		.findOne(Integer.valueOf(text));
	setValue(commodityStatus);
    }
}
