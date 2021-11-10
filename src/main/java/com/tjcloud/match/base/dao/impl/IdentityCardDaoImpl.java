package com.tjcloud.match.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.match.base.dao.IdentityCardDao;
import com.tjcloud.match.base.entity.IdentityCard;
import org.springframework.stereotype.Repository;

@Repository("identityCardDao")
public class IdentityCardDaoImpl extends AbstractIBatisDaoImpl<IdentityCard, String> implements IdentityCardDao {

}
