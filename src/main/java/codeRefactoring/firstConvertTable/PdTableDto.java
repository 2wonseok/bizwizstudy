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
public class PdTableDto {
    @Schema(description = "Project No.", example = "")
    @JsonAlias({"prj_no", "prjNo", ""})
    private String prj_no;
    @Schema(description = "Status", example = "")
    @JsonAlias({"status", "status", ""})
    private String status;
    @Schema(description = "Cata Type", example = "")
    @JsonAlias({"cata_type", "cataType", ""})
    private String cata_type;

    @Schema(description = "Material Master Code", example = "")
    @JsonAlias({"material_code", "materialCode", ""})
    private String material_code;
    @Schema(description = "Description", example = "")
    @JsonAlias({"material_desc", "materialDesc", ""})
    private String material_desc;
    @Schema(description = "Description Rev.", example = "")
    @JsonAlias({"rev_no", "revNo", ""})
    private String rev_no;
    @Schema(description = "Rev. Date", example = "")
    @JsonAlias({"rev_date", "revDate", ""})
    private String rev_date;
    @Schema(description = "I/F Source", example = "")
    @JsonAlias({"source", "source", ""})
    private String source;
    @Schema(description = "Admin Confirm Date", example = "")
    @JsonAlias({"admin_confirm_date", "adminConfirmDate", ""})
    private String admin_confirm_date;
    @Schema(description = "Dimension Source", example = "")
    @JsonAlias({"dim_source", "dimSource", ""})
    private String dim_source;


    @Schema(description = "Dimension Code", example = "")
    @JsonAlias({"dim_code", "dimCode", ""})
    private String dim_code;
    @Schema(description = "Dimension Table", example = "")
    @JsonAlias({"dim_table", "dimTable", ""})
    private String dim_table;
    @Schema(description = "Main Size", example = "")
    @JsonAlias({"main_size", "mainSize", ""})
    private String main_size;
    @Schema(description = "Branch Size", example = "")
    @JsonAlias({"branch_size", "branchSize", ""})
    private String branch_size;
    @Schema(description = "WALTHK Description", example = "")
    @JsonAlias({"walthk_desc", "walthkDesc", ""})
    private String walthk_desc;

    @Schema(description = "End Conn", example = "")
    @JsonAlias({"end_conn", "endConn", ""})
    private String end_conn;
    @Schema(description = "Pressure Rating", example = "")
    @JsonAlias({"pressure_rating", "pressureRating", ""})
    private String pressure_rating;
    @Schema(description = "Part Class Name", example = "")
    @JsonAlias({"part_class_name", "partClassName", ""})
    private String part_class_name;
    @Schema(description = "PDB", example = "")
    @JsonAlias({"pdb", "pdb", ""})
    private String pdb;

    @Schema(description = "Item", example = "")
    @JsonAlias({"item", "item", ""})
    private String item;
    @Schema(description = "Maker", example = "")
    @JsonAlias({"maker", "maker", ""})
    private String maker;
    @Schema(description = "Dimension1", example = "")
    @JsonAlias({"dim1", "dim1", ""})
    private String dim1;
    @Schema(description = "Dimension2", example = "")
    @JsonAlias({"dim2", "dim2", ""})
    private String dim2;
    @Schema(description = "Dimension3", example = "")
    @JsonAlias({"dim3", "dim3", ""})
    private String dim3;
    @Schema(description = "Dimension4", example = "")
    @JsonAlias({"dim4", "dim4", ""})
    private String dim4;
    @Schema(description = "Dimension5", example = "")
    @JsonAlias({"dim5", "dim5", ""})
    private String dim5;
    @Schema(description = "Dimension6", example = "")
    @JsonAlias({"dim6", "dim6", ""})
    private String dim6;
    @Schema(description = "Dimension7", example = "")
    @JsonAlias({"dim7", "dim7", ""})
    private String dim7;
    @Schema(description = "Dimension8", example = "")
    @JsonAlias({"dim8", "dim8", ""})
    private String dim8;
    @Schema(description = "Dimension9", example = "")
    @JsonAlias({"dim9", "dim9", ""})
    private String dim9;
    @Schema(description = "Dimension10", example = "")
    @JsonAlias({"dim10", "dim10", ""})
    private String dim10;

    @Schema(description = "PO No.", example = "")
    @JsonAlias({"po_no", "poNo", ""})
    private String po_no;
    @Schema(description = "VP No.", example = "")
    @JsonAlias({"vp_no", "vpNo", ""})
    private String vp_no;

    @Schema(description = "Delete - Y or N", example = "")
    @JsonAlias({"del_yn", "delYn", ""})
    private String del_yn;
    @Schema(description = "Revision Status", example = "")
    @JsonAlias("revisionStatus")
    private String revision_status;    

    private String dim_key;

    // 엑셀 생성용 List Map (Key : 필드명, value : 헤더명)
    private List<LinkedHashMap<String,String>> getExcelField() {  // opt: key, value
        List<LinkedHashMap<String,String>> fieldList= new ArrayList<>();
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        map.put("status", "Status");
        map.put("cata_type", "Cata Type");
        map.put("material_code", "Material Master Code");
        map.put("material_desc", "Description");
        map.put("rev_no", "Rev.");
        map.put("rev_date", "Rev. Date");
        map.put("source", "I/F Source");
        map.put("admin_confirm_date", "Admin Confirm Date");
        map.put("idm_source", "Dimension Source");
        map.put("dim_code", "Dimension Code");
        map.put("dim_table", "Dimension Table");
        map.put("main_size", "Main Size");
        map.put("branch_size", "Branch Size");
        map.put("walthk_desc", "WALTHK Description");
        map.put("end_conn", "End Conn");
        map.put("pressure_rating", "Pressure Rating");
        map.put("part_class_name", "Part Class Name");
        map.put("pdb", "PDB");
        map.put("item", "Item");
        map.put("maker", "Maker");
        map.put("dim1", "Dimension1");
        map.put("dim2", "Dimension2");
        map.put("dim3", "Dimension3");
        map.put("dim4", "Dimension4");
        map.put("dim5", "Dimension5");
        map.put("dim6", "Dimension6");
        map.put("dim7", "Dimension7");
        map.put("dim8", "Dimension8");
        map.put("dim9", "Dimension9");
        map.put("dim10", "Dimension10");
        map.put("po_no", "PO No.");
        map.put("vp_no", "VP No.");

        fieldList.add(map);
        return fieldList;
    }
}
