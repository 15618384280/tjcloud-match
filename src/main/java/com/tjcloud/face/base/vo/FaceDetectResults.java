package com.tjcloud.face.base.vo;

import java.io.Serializable;

public class FaceDetectResults implements Serializable{

	private static final long serialVersionUID = 82165593698433905L;
	
	private Integer faceNum;						//检测到的图片中的人脸数量
	private String faceToken;					//人脸图片的唯一标识
	private Double left;							//人脸区域离左边界的距离
	private Double top;							//人脸区域离上边界的距离
	private Double width;						//人脸区域的宽度
	private Double height;						//人脸区域的高度
	private Integer rotation;					//人脸框相对于竖直方向的顺时针旋转角，[-180,180]
	private Double faceProbability;				//人脸置信度，范围【0~1】，代表这是一张人脸的概率，0最小、1最大。
	private Double angelYaw;						//三维旋转之左右旋转角[-90(左), 90(右)]
	private Double angelPitch;					//三维旋转之俯仰角度[-90(上), 90(下)]
	private Double angelRoll;					//平面内旋转角[-180(逆时针), 180(顺时针)]
	private Double age;							//年龄 ，当face_field包含age时返回
	private Integer beauty;						//美丑打分，范围0-100，越大表示越美。当face_fields包含beauty时返回
	private String expressionType;				//none:不笑；smile:微笑；laugh:大笑
	private Double expressionProbability;		//表情置信度，范围【0~1】，0最小、1最大。
	private String faceShapeType;				//square: 正方形 triangle:三角形 oval: 椭圆 heart: 心形 round: 圆形
	private Double faceShapeProbability;			//置信度，范围【0~1】，代表这是人脸形状判断正确的概率，0最小、1最大。
	private String genderType;					//male:男性 female:女性
	private Double genderProbability;			//性别置信度，范围【0~1】，0代表概率最小、1代表最大。
	private String glassesType;					//none:无眼镜，common:普通眼镜，sun:墨镜
	private Double glassesProbability;			//眼镜置信度，范围【0~1】，0代表概率最小、1代表最大。
	private Double eyeStatusLeftEye;				//左眼状态 [0,1]取值，越接近0闭合的可能性越大
	private Double eyeStatusRightEye;			//右眼状态 [0,1]取值，越接近0闭合的可能性越大
	private String emotionType;					//angry:愤怒 disgust:厌恶 fear:恐惧 happy:高兴sad:伤心 surprise:惊讶 neutral:无情绪
	private Double emotionProbability;			//情绪置信度，范围0~1
	private String raceType;						//yellow: 黄种人 white: 白种人 black:黑种人 arabs: 阿拉伯人
	private Double raceProbability;				//人种置信度，范围【0~1】，0代表概率最小、1代表最大。
	private String faceType;						//human: 真实人脸 cartoon: 卡通人脸
	private Double faceTypeProbability;			//人脸类型判断正确的置信度，范围【0~1】，0代表概率最小、1代表最大。
	private Double qualityLeftEye;				//左眼遮挡比例，[0-1] ， 1表示完全遮挡
	private Double qualityRightEye;				//右眼遮挡比例，[0-1] ， 1表示完全遮挡
	private Double qualityNose;					//鼻子遮挡比例，[0-1] ， 1表示完全遮挡
	private Double qualityMouth;					//嘴巴遮挡比例，[0-1] ， 1表示完全遮挡
	private Double qualityLeftCheek;				//左脸颊遮挡比例，[0-1] ， 1表示完全遮挡
	private Double qualityRightCheek;			//右脸颊遮挡比例，[0-1] ， 1表示完全遮挡
	private Double qualityChin;					//下巴遮挡比例，，[0-1] ， 1表示完全遮挡
	private Double qualityBlur;					//人脸模糊程度，范围[0~1]，0表示清晰，1表示模糊
	private Double qualityIllumination;			//取值范围在[0~255], 表示脸部区域的光照程度 越大表示光照越好
	private Integer qualityCompleteness;			//人脸完整度，0或1, 0为人脸溢出图像边界，1为人脸都在图像边界内
	public Integer getFaceNum() {
		return faceNum;
	}
	public void setFaceNum(Integer faceNum) {
		this.faceNum = faceNum;
	}
	public String getFaceToken() {
		return faceToken;
	}
	public void setFaceToken(String faceToken) {
		this.faceToken = faceToken;
	}
	public Double getLeft() {
		return left;
	}
	public void setLeft(Double left) {
		this.left = left;
	}
	public Double getTop() {
		return top;
	}
	public void setTop(Double top) {
		this.top = top;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Integer getRotation() {
		return rotation;
	}
	public void setRotation(Integer rotation) {
		this.rotation = rotation;
	}
	public Double getFaceProbability() {
		return faceProbability;
	}
	public void setFaceProbability(Double faceProbability) {
		this.faceProbability = faceProbability;
	}
	public Double getAngelYaw() {
		return angelYaw;
	}
	public void setAngelYaw(Double angelYaw) {
		this.angelYaw = angelYaw;
	}
	public Double getAngelPitch() {
		return angelPitch;
	}
	public void setAngelPitch(Double angelPitch) {
		this.angelPitch = angelPitch;
	}
	public Double getAngelRoll() {
		return angelRoll;
	}
	public void setAngelRoll(Double angelRoll) {
		this.angelRoll = angelRoll;
	}
	public Double getAge() {
		return age;
	}
	public void setAge(Double age) {
		this.age = age;
	}
	public Integer getBeauty() {
		return beauty;
	}
	public void setBeauty(Integer beauty) {
		this.beauty = beauty;
	}
	public String getExpressionType() {
		return expressionType;
	}
	public void setExpressionType(String expressionType) {
		this.expressionType = expressionType;
	}
	public Double getExpressionProbability() {
		return expressionProbability;
	}
	public void setExpressionProbability(Double expressionProbability) {
		this.expressionProbability = expressionProbability;
	}
	public String getFaceShapeType() {
		return faceShapeType;
	}
	public void setFaceShapeType(String faceShapeType) {
		this.faceShapeType = faceShapeType;
	}
	public Double getFaceShapeProbability() {
		return faceShapeProbability;
	}
	public void setFaceShapeProbability(Double faceShapeProbability) {
		this.faceShapeProbability = faceShapeProbability;
	}
	public String getGenderType() {
		return genderType;
	}
	public void setGenderType(String genderType) {
		this.genderType = genderType;
	}
	public Double getGenderProbability() {
		return genderProbability;
	}
	public void setGenderProbability(Double genderProbability) {
		this.genderProbability = genderProbability;
	}
	public String getGlassesType() {
		return glassesType;
	}
	public void setGlassesType(String glassesType) {
		this.glassesType = glassesType;
	}
	public Double getGlassesProbability() {
		return glassesProbability;
	}
	public void setGlassesProbability(Double glassesProbability) {
		this.glassesProbability = glassesProbability;
	}
	public Double getEyeStatusLeftEye() {
		return eyeStatusLeftEye;
	}
	public void setEyeStatusLeftEye(Double eyeStatusLeftEye) {
		this.eyeStatusLeftEye = eyeStatusLeftEye;
	}
	public Double getEyeStatusRightEye() {
		return eyeStatusRightEye;
	}
	public void setEyeStatusRightEye(Double eyeStatusRightEye) {
		this.eyeStatusRightEye = eyeStatusRightEye;
	}
	public String getEmotionType() {
		return emotionType;
	}
	public void setEmotionType(String emotionType) {
		this.emotionType = emotionType;
	}
	public Double getEmotionProbability() {
		return emotionProbability;
	}
	public void setEmotionProbability(Double emotionProbability) {
		this.emotionProbability = emotionProbability;
	}
	public String getRaceType() {
		return raceType;
	}
	public void setRaceType(String raceType) {
		this.raceType = raceType;
	}
	public Double getRaceProbability() {
		return raceProbability;
	}
	public void setRaceProbability(Double raceProbability) {
		this.raceProbability = raceProbability;
	}
	public String getFaceType() {
		return faceType;
	}
	public void setFaceType(String faceType) {
		this.faceType = faceType;
	}
	public Double getFaceTypeProbability() {
		return faceTypeProbability;
	}
	public void setFaceTypeProbability(Double faceTypeProbability) {
		this.faceTypeProbability = faceTypeProbability;
	}
	public Double getQualityLeftEye() {
		return qualityLeftEye;
	}
	public void setQualityLeftEye(Double qualityLeftEye) {
		this.qualityLeftEye = qualityLeftEye;
	}
	public Double getQualityRightEye() {
		return qualityRightEye;
	}
	public void setQualityRightEye(Double qualityRightEye) {
		this.qualityRightEye = qualityRightEye;
	}
	public Double getQualityNose() {
		return qualityNose;
	}
	public void setQualityNose(Double qualityNose) {
		this.qualityNose = qualityNose;
	}
	public Double getQualityMouth() {
		return qualityMouth;
	}
	public void setQualityMouth(Double qualityMouth) {
		this.qualityMouth = qualityMouth;
	}
	public Double getQualityLeftCheek() {
		return qualityLeftCheek;
	}
	public void setQualityLeftCheek(Double qualityLeftCheek) {
		this.qualityLeftCheek = qualityLeftCheek;
	}
	public Double getQualityRightCheek() {
		return qualityRightCheek;
	}
	public void setQualityRightCheek(Double qualityRightCheek) {
		this.qualityRightCheek = qualityRightCheek;
	}
	public Double getQualityChin() {
		return qualityChin;
	}
	public void setQualityChin(Double qualityChin) {
		this.qualityChin = qualityChin;
	}
	public Double getQualityBlur() {
		return qualityBlur;
	}
	public void setQualityBlur(Double qualityBlur) {
		this.qualityBlur = qualityBlur;
	}
	public Double getQualityIllumination() {
		return qualityIllumination;
	}
	public void setQualityIllumination(Double qualityIllumination) {
		this.qualityIllumination = qualityIllumination;
	}
	public Integer getQualityCompleteness() {
		return qualityCompleteness;
	}
	public void setQualityCompleteness(Integer qualityCompleteness) {
		this.qualityCompleteness = qualityCompleteness;
	}
	
	
}
