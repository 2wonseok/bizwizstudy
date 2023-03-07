package codeRefactoring.firstConvertTable;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Data
@NoArgsConstructor
public class PipingValveDimmConvDto {
    @Schema(description = "Project No.", example = "")
    @JsonAlias({"prj_no", "prjNo", ""})
    private String prj_no;
    @Schema(description = "Cata Type", example = "")
    @JsonAlias({"cataType","Cata Type"})
    private String cata_type;
    @Schema(description = "Size", example = "")
    @JsonAlias({"size","Size"})
    private String size;
    @Schema(description = "Rating", example = "")
    @JsonAlias({"rating","Rating"})
    private String rating;
    @Schema(description = "FacetoFace", example = "")
    @JsonAlias({"faceToFace","FacetoFace"})
    private String face_to_face;
    @Schema(description = "OffsetFrmValCen", example = "")
    @JsonAlias({"offsetFrmValCen","OffsetFrmValCen"})
    private String offset_frm_val_cen;
    @Schema(description = "ValCenLineToBot", example = "")
    @JsonAlias({"valCenLineToBot","ValCenLineToBot"})
    private String val_cen_line_to_bot;
    @Schema(description = "HeightFrmValCen", example = "")
    @JsonAlias({"heightFrmValCen","HeightFrmValCen"})
    private String height_frm_val_cen;
    @Schema(description = "Diameter", example = "")
    @JsonAlias({"diameter","Diameter"})
    private String diameter;
    @Schema(description = "NippleLength", example = "")
    @JsonAlias({"nippleLength","NippleLength"})
    private String nipple_length;
    @Schema(description = "Width", example = "")
    @JsonAlias({"width","Width"})
    private String width;
    @Schema(description = "OperatorHeight", example = "")
    @JsonAlias({"operatorHeight","OperatorHeight"})
    private String operator_height;
    @Schema(description = "HWDiameter", example = "")
    @JsonAlias({"hwDiameter","HWDiameter"})
    private String hw_diameter;
    @Schema(description = "Height", example = "")
    @JsonAlias({"height","Height"})
    private String height;
    @Schema(description = "HandleLength", example = "")
    @JsonAlias({"handleLength","HandleLength"})
    private String handle_length;
    @Schema(description = "Rotation", example = "")
    @JsonAlias({"rotation","Rotation"})
    private String rotation;
    @Schema(description = "LeverLength", example = "")
    @JsonAlias({"leverLength","LeverLength"})
    private String lever_length;
    @Schema(description = "LeverHeight", example = "")
    @JsonAlias({"leverHeight","LeverHeight"})
    private String lever_height;
    @Schema(description = "BaseRadius", example = "")
    @JsonAlias({"baseRadius","BaseRadius"})
    private String base_radius;
    @Schema(description = "GearDiameter", example = "")
    @JsonAlias({"gearDiameter","GearDiameter"})
    private String gear_diameter;
    @Schema(description = "GearDepth", example = "")
    @JsonAlias({"gearDepth","GearDepth"})
    private String gear_depth;
    @Schema(description = "HwZOffsetOpFrmStem", example = "")
    @JsonAlias({"hwZOffsetOpFrmStem","HwZOffsetOpFrmStem"})
    private String hw_z_offset_op_frm_stem;
    @Schema(description = "StemDiameter", example = "")
    @JsonAlias({"stemDiameter","StemDiameter"})
    private String stem_diameter;
    @Schema(description = "ShaftDiameter", example = "")
    @JsonAlias({"shaftDiameter","ShaftDiameter"})
    private String shaft_diameter;
    @Schema(description = "HwXOffsetFrmOpStem", example = "")
    @JsonAlias({"hwXOffsetFrmOpStem","HwXOffsetFrmOpStem"})
    private String hw_x_offset_frm_op_stem;
    @Schema(description = "B", example = "")
    @JsonAlias({"b","B"})
    private String b;
    @Schema(description = "HwYOffsetFrmGearBot", example = "")
    @JsonAlias({"hwYOffsetFrmGearBot","HwYOffsetFrmGearBot"})
    private String hw_y_offset_gear_bot;
    @Schema(description = "Offset", example = "")
    @JsonAlias({"offset","Offset"})
    private String offset;
    ////////////////////////////////////////////////////////////////////////
    @Schema(description = "Revision Status", example = "")
    @JsonAlias("revisionStatus")
    private String revision_status;
    @Schema(description = "Delete - Y or N", example = "")
    @JsonAlias("delYn")
    private String del_yn;

    private String error_code;

    @Schema(description = "Error Message", example = "")
    @JsonAlias("errorMessage")
    private String error_message;
    @Schema(description = "Error Column Name Array", example = "")
    @JsonAlias("errorColArr")
    private List<String> error_col_arr;
    @Schema(description = "Error Yn", example = "")
    @JsonAlias("errorYn")
    private String error_yn;

    // 엑셀 생성용 List Map (Key : 필드명, value : 헤더명)
    private List<LinkedHashMap<String,String>> getExcelField() {  // opt: key, value
        List<LinkedHashMap<String,String>> fieldList= new ArrayList<>();
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        map.put("cata_type", "Cata Type");
        map.put("size", "Size");
        map.put("rating", "Rating");
        map.put("face_to_face", "FaceToFace");
        map.put("offset_frm_val_cen", "OffsetFrmValCen");
        map.put("val_cen_line_to_bot", "ValCenLineToBot");
        map.put("height_frm_val_cen", "HeightFrmValCen");
        map.put("diameter", "Diameter");
        map.put("nipple_length", "NippleLength");
        map.put("width", "Width");
        map.put("operator_height", "OperatorHeight");
        map.put("hw_diameter", "HWDiameter");
        map.put("height", "Height");
        map.put("handle_length", "HandleLength");
        map.put("rotation", "Rotation");
        map.put("lever_length", "LeverLength");
        map.put("lever_height", "LeverHeight");
        map.put("base_radius", "BaseRadius");
        map.put("gear_diameter", "GearDiameter");
        map.put("gear_depth", "GearDepth");
        map.put("hw_z_offset_op_frm_stem", "HwZOffsetOpFrmStem");
        map.put("stem_diameter", "StemDiameter");
        map.put("shaft_diameter", "ShaftDiameter");
        map.put("hw_x_offset_frm_op_stem", "HwXOffsetFrmOpStem");
        map.put("b", "B");
        map.put("hw_y_offset_gear_bot", "HwYOffsetFrmGearBot");
        map.put("offset", "Offset");
        map.put("del_yn", "Del yn");

        fieldList.add(map);
        return fieldList;
    }
}