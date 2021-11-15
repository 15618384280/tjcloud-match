package com.tjcloud.match.base.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.match.api.enums.Sex;
import com.tjcloud.match.api.utils.SignRecordFieldUtils;
import com.tjcloud.match.base.entity.MatchInfo;
import com.tjcloud.match.base.entity.MatchSubject;
import com.tjcloud.match.base.entity.SignRecord;
import com.tjcloud.match.base.entity.SignRecordFieldTable;

import java.util.List;
import java.util.Map;

/**
 * 赛事报名(sign_record)
 *
 * @author auto bin.yin 2017.03.04
 */
public class SignRecordVO<T extends SignRecordFieldTable> extends SignRecord {

    private static final long serialVersionUID = -8566281541400351065L;
    private String teamName; // 如果是新增队长，则需要团队名称
    private List<T> signRecordInfo = Lists.newArrayList();
    private MatchSubject matchSubject;
    private MatchInfo matchInfo;
    @JsonIgnore
    private Boolean manageUser; //管理用户
    @JsonIgnore
    private Map<String, T> mapvo;

    public Map<String, T> getMapvo() {
        return mapvo;
    }

//    public void setMapvo(Map<String, T> mapvo) {
//        this.mapvo = mapvo;
//    }

    public List<T> getSignRecordInfo() {
        return signRecordInfo;
    }

    public void setSignRecordInfo(List<T> signRecordInfo) {
        this.signRecordInfo = signRecordInfo;
        mapvo = Maps.newHashMap();
        for (T signRecordFieldTable : signRecordInfo) {
            // 如果是四个基本字段
            if (SignRecordFieldUtils.isBasicSignField(signRecordFieldTable.getControlKey())) {
                String value = signRecordFieldTable.getValue();
                if (StringUtils.equals(signRecordFieldTable.getControlKey(), SignRecordFieldUtils.nameControlKey)) {
                    super.setName(value);
                } else if (StringUtils.equals(signRecordFieldTable.getControlKey(), SignRecordFieldUtils.sexControlKey)) {
                    super.setSex(Sex.WOMAN.getText().equals(value) ? Sex.WOMAN.getStatus() : Sex.MAN.getStatus());
                } else if (StringUtils.equals(signRecordFieldTable.getControlKey(), SignRecordFieldUtils.phoneControlKey)) {
                    super.setPhone(value);
                } else if (StringUtils.equals(signRecordFieldTable.getControlKey(), SignRecordFieldUtils.cerControlKey)) {
                    super.setCertificateNo(value);
                }
            }
            mapvo.put(signRecordFieldTable.getControlKey(), signRecordFieldTable);
        }


    }

	public MatchSubject getMatchSubject() {
		return matchSubject;
	}

	public void setMatchSubject(MatchSubject matchSubject) {
		this.matchSubject = matchSubject;
	}

	public MatchInfo getMatchInfo() {
		return matchInfo;
	}

	public void setMatchInfo(MatchInfo matchInfo) {
		this.matchInfo = matchInfo;
	}

	public Boolean isManageUser() {
        return (this.manageUser==null) ? false : manageUser;
    }

    public void setManageUser(Boolean manageUser) {
        this.manageUser = (manageUser==null) ? false : manageUser;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}