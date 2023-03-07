package codeRefactoring.firstConvertTable;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class firstConvertTable {






    public List<PipingValveDimmConvDto> getConvertedDimmData(String prj_no) {

        List<PipingValveDimmConvDto> valveList = this.getValveDimmConvList(prj_no);
        List<PdTableDto> pdList = this.getPdTableDataList(prj_no);

        List<PipingValveDimmConvDto> pdAddList = new ArrayList<PipingValveDimmConvDto>();

        for (PdTableDto pdDto : pdList) { //pdTable에서 valveList와 key가 중복되지 않는 항목들 찾아 convert해서 add

            boolean isDupKey = false;

            for (PipingValveDimmConvDto dto : valveList) {
                // TODO COMPARE KEY AND Calc

                //key null체크 추가
                if(StringUtils.isEmpty(pdDto.getCata_type()) ||
                        StringUtils.isEmpty(pdDto.getMain_size()) ||
                        StringUtils.isEmpty(pdDto.getPressure_rating())
                ){
                    continue;
                }

                if (/* pdDto.getPrj_no().equals(dto.getPrj_no())
                        && */ pdDto.getCata_type().equals(dto.getCata_type())
                        && pdDto.getMain_size().equals(dto.getSize())
                        && pdDto.getPressure_rating().equals(dto.getRating())
                ) {
                    dto.setRevision_status("edit");
                    isDupKey = true;
                }
            }

            if(isDupKey) {
                continue; // not add
            }

            PipingValveDimmConvDto resDto = new PipingValveDimmConvDto();
            resDto.setRevision_status("add");


            // convert
            PipingValveDimmConvDto matchedConvTableDto = getMatchedPipingValveConvTableRow(pdDto);
            if(Objects.nonNull(matchedConvTableDto)){
                convertPdToPipingValve(matchedConvTableDto,pdDto);
                resDto = matchedConvTableDto;
                pdAddList.add(resDto);
            }

            /* todo del old version */
            // resDto = this.fnConvertToValveDimm(resDto, pdDto); //todo 매칭되는 key가 없으면 다 0으로 결과가 나와서 add될 것 => 0인 데이터 제거필요
            // pdAddList.add(resDto);

        }

        List<PipingValveDimmConvDto> resultList = new ArrayList<PipingValveDimmConvDto>();
        resultList.addAll(valveList); //기존 데이터 유지
        resultList.addAll(pdAddList);

        return resultList;
    }

    //기존코드
    /* todo del 기존 로직 */
    private PipingValveDimmConvDto fnConvertToValveDimm(PipingValveDimmConvDto resDto, PdTableDto pdDto){
        float fSetOffsetFrmValCen = 0.0F;
        int iDim2 = 0;
        int iDim3 = 0;
        int iDim4 = 0;
        int iDim5 = 0;
        int iGearDiameter = 0;
        int iGearDepth = 0;
        int iValCenLineToBot = 0;
        int iWidth = 0;
        int iHwYOffsetFrmGearBot = 0;
        int iLeverHeight = 0;
        int iBaseRadius = 0;
        int iOffsetFrmValCen = 0;
        float fHwZOffsetOpFrmStem = 0.0F;
        float fStemDiameter = 0.0F;
        switch(pdDto.getCata_type().toUpperCase().replaceAll(" ","").replaceAll("_","")){
            case "GATEVALVEHANDWHEELNIP" : // GateValve_Handwheel
                if(pdDto.getPressure_rating().equals("*")) {
                    resDto.setNipple_length(pdDto.getDim4());
                }
            case "GATEVALVEHANDWHEEL" : // GateValve_Handwheel_NIP
                if(pdDto.getPressure_rating().equals("*")) {
                    resDto.setFace_to_face(pdDto.getDim1());
                    resDto.setOperator_height(pdDto.getDim2());
                    resDto.setHw_diameter(pdDto.getDim3());
                    iDim2 = this.fnToInt(pdDto.getDim2());
                    switch (pdDto.getMain_size()) {
                        case "A000150":    // 1/2
                            fSetOffsetFrmValCen = iDim2 - (21F / 0.6F);
                            break;
                        case "A000200":    // 3/4
                            fSetOffsetFrmValCen = iDim2 - (26F / 0.6F);
                            break;
                        case "A000250":    // 1
                            fSetOffsetFrmValCen = iDim2 - (33F / 0.6F);
                            break;
                        case "A000400":    // 1-1/2
                            fSetOffsetFrmValCen = iDim2 - (48F / 0.6F);
                            break;
                        case "A000500":    // 2
                            fSetOffsetFrmValCen = iDim2 - (60F / 0.6F);
                            break;
                        case "A000800":    // 3
                            fSetOffsetFrmValCen = iDim2 - (86F / 0.6F);
                            break;
                        case "A001000":    // 4
                            fSetOffsetFrmValCen = iDim2 - (113F / 0.6F);
                            break;
                        case "A001500":    // 6
                            fSetOffsetFrmValCen = iDim2 - (166F / 0.6F);
                            break;
                        case "A002000":    // 8
                            fSetOffsetFrmValCen = iDim2 - (218F / 0.6F);
                            break;
                        case "A002500":    // 10
                            fSetOffsetFrmValCen = iDim2 - (273F / 0.6F);
                            break;
                        case "A003000":    // 12
                            fSetOffsetFrmValCen = iDim2 - (300F / 0.6F);
                            break;
                        case "A003500":    // 14
                            fSetOffsetFrmValCen = iDim2 - (348F / 0.6F);
                            break;
                        default:
                            break;
                    }
                    resDto.setOffset_frm_val_cen(String.valueOf(fSetOffsetFrmValCen));
                }
                break;
            case "GATEVALVEGEAR" : // GateValve_Gear
                if(pdDto.getPressure_rating().equals("*")) {
                    resDto.setFace_to_face(pdDto.getDim1());
                    resDto.setOperator_height(pdDto.getDim2());
                    resDto.setHw_diameter(pdDto.getDim4());
                    resDto.setHw_z_offset_op_frm_stem(pdDto.getDim5());
                    iDim3 = this.fnToInt(pdDto.getDim3());
                    switch (pdDto.getMain_size()) {
                        case "A000500":    // 2
                            iGearDiameter = 150;
                            iGearDepth = 100;
                            break;
                        case "A000800":    // 3
                        case "A001000":    // 4
                            iGearDiameter = 175;
                            iGearDepth = 117;
                            break;
                        case "A001500":    // 6
                        case "A002000":    // 8
                            iGearDiameter = 310;
                            iGearDepth = 130;
                            break;
                        case "A002500":    // 10
                        case "A003000":    // 12
                        case "A003500":    // 14
                            iGearDiameter = 300;
                            iGearDepth = 160;
                            break;
                        case "A004000":    // 16
                        case "A004500":    // 18
                            iGearDiameter = 350;
                            iGearDepth = 215;
                            break;
                        case "A005000":    // 20
                        case "A005500":    // 22
                        case "A006000":    // 24
                        case "A006500":    // 26
                            iGearDiameter = 415;
                            iGearDepth = 330;
                            break;
                        case "A007000":    // 28
                        case "A007500":    // 30
                            iGearDiameter = 460;
                            iGearDepth = 350;
                            break;
                        case "A008000":    // 32
                            iGearDiameter = 510;
                            iGearDepth = 350;
                            break;
                        case "A008500":    // 34
                        case "A009000":    // 36
                        case "A009500":    // 38
                        case "A010000":    // 40
                        case "A010500":    // 42
                        case "A011000":    // 44
                        case "A011500":    // 46
                        case "A012000":    // 48
                        case "A012500":    // 50
                        case "A013000":    // 52
                        case "A013500":    // 54
                        case "A014000":    // 56
                            iGearDiameter = 620;
                            iGearDepth = 360;
                            break;
                        case "A014500":    // 58
                        case "A015000":    // 60
                        case "A015500":    // 62
                        case "A016000":    // 64
                        case "A016500":    // 66
                        case "A017000":    // 68
                        case "A017500":    // 70
                        case "A018000":    // 72
                        case "A018500":    // 74
                        case "A019000":    // 76
                            iGearDiameter = 620;
                            iGearDepth = 360;
                            break;
                        case "A019500":    // 78
                        case "A020000":    // 80
                        case "A020500":    // 82
                        case "A021000":    // 84
                        case "A021500":    // 86
                        case "A022000":    // 88
                            iGearDiameter = 750;
                            iGearDepth = 460;
                            break;
                        case "A022500":    // 90
                        case "A023000":    // 92
                        case "A023500":    // 94
                        case "A024000":    // 96
                        case "A024500":    // 98
                        case "A025000":    // 100
                            iGearDiameter = 810;
                            iGearDepth = 480;
                            break;
                        default:
                            break;
                    }
                    //DIM3 - "GearDepth"/2
                    fSetOffsetFrmValCen = iDim3 - (iGearDepth / 2F);
                    fHwZOffsetOpFrmStem = iGearDepth * 0.2F;
                    fStemDiameter = iGearDiameter * 0.4F;
                    resDto.setGear_diameter(String.valueOf(iGearDiameter));
                    resDto.setGear_depth(String.valueOf(iGearDepth));
                    resDto.setOffset_frm_val_cen(String.valueOf(fSetOffsetFrmValCen));
                    resDto.setHw_z_offset_op_frm_stem(String.valueOf(fHwZOffsetOpFrmStem));
                    resDto.setStem_diameter(String.valueOf(fStemDiameter));
                }
                break;
            case "GLOBEVALVEHANDWHEEL" : // GlobeValve_Handwheel
                if(pdDto.getPressure_rating().equals("*")) {
                    resDto.setFace_to_face(pdDto.getDim1());
                    resDto.setOperator_height(pdDto.getDim2());
                    resDto.setHw_diameter(pdDto.getDim3());
                    iDim2 = this.fnToInt(pdDto.getDim2());
                    switch (pdDto.getMain_size()) {
                        case "A000150":    // 1/2
                        case "A000200":    // 3/4
                            fSetOffsetFrmValCen = iDim2 - 35;
                            break;
                        case "A000250":    // 1
                            fSetOffsetFrmValCen = iDim2 - 40;
                            break;
                        case "A000400":    // 1-1/2
                            fSetOffsetFrmValCen = iDim2 - 45;
                            break;
                        case "A000500":    // 2
                            fSetOffsetFrmValCen = iDim2 - 50;
                            break;
                        case "A000800":    // 3
                            fSetOffsetFrmValCen = iDim2 - 58;
                            break;
                        case "A001000":    // 4
                            fSetOffsetFrmValCen = iDim2 - 70;
                            break;
                        case "A001500":    // 6
                            fSetOffsetFrmValCen = iDim2 - 80;
                            break;
                        case "A002000":    // 8
                            fSetOffsetFrmValCen = iDim2 - 90;
                            break;
                        case "A002500":    // 10
                            fSetOffsetFrmValCen = iDim2 - 105;
                            break;
                        case "A003000":    // 12
                            fSetOffsetFrmValCen = iDim2 - 110;
                            break;
                        case "A003500":    // 14
                            fSetOffsetFrmValCen = iDim2 - 120;
                            break;
                        default:
                            break;
                    }
                    resDto.setOffset_frm_val_cen(String.valueOf(fSetOffsetFrmValCen));
                }
                break;
            case "GLOBEVALVEHANDWHEELNIP" : // GlobeValve_Handwheel_NIP
                if(pdDto.getPressure_rating().equals("*")) {
                    resDto.setFace_to_face(pdDto.getDim1());
                    resDto.setOperator_height(pdDto.getDim2());
                    resDto.setHw_diameter(pdDto.getDim3());
                    if(! pdDto.getMain_size().equals("A003500")){ //14 제외
                        resDto.setNipple_length(pdDto.getDim4());
                    }
                }
                break;
            case "GLOBEVALVEGEAR" : // GlobeValve_Gear
                iDim2 = this.fnToInt(pdDto.getDim2());
                iDim3 = this.fnToInt(pdDto.getDim3());
                resDto.setFace_to_face(pdDto.getDim1());
                resDto.setOffset_frm_val_cen(String.valueOf(iDim2 * 0.44));
                resDto.setOperator_height(String.valueOf(iDim2 * 0.56));
                resDto.setHw_diameter(pdDto.getDim4());
                resDto.setGear_depth(String.valueOf(2 * (iDim2 - iDim3)));
                resDto.setHw_x_offset_frm_op_stem(pdDto.getDim5());

                switch (pdDto.getPressure_rating()) {
                    case "150" :
                        switch (pdDto.getMain_size()) {
                            case "A002000":    // 8
                                iGearDepth = 178;
                                break;
                            case "A002500":    // 10
                                iGearDepth = 216;
                                break;
                            case "A003000":    // 12
                            case "A003500":    // 14
                                iGearDepth = 290;
                                break;
                            case "A004000":    // 16
                            case "A004500":    // 18
                                iGearDepth = 350;
                                break;
                            case "A005000":    // 20
                            case "A005500":    // 22
                            case "A006000":    // 24
                                iGearDepth = 510;
                                break;
                            default:
                                break;
                        }
                        break;
                    case "300" :
                        switch (pdDto.getMain_size()) {
                            case "A001500":    // 6
                                iGearDepth = 216;
                                break;
                            case "A002000":    // 8
                                iGearDepth = 290;
                                break;
                            case "A002500":    // 10
                            case "A003000":    // 12
                                iGearDepth = 350;
                                break;
                            case "A003500":    // 14
                            case "A004000":    // 16
                                iGearDepth = 510;
                                break;
                            case "A004500":    // 18
                            case "A005000":    // 20
                            case "A005500":    // 22
                            case "A006000":    // 24
                                iGearDepth = 620;
                                break;
                            default:
                                break;
                        }
                        break;
                    case "600" :
                        switch (pdDto.getMain_size()) {
                            case "A001000":    // 4
                                iGearDepth = 216;
                                break;
                            case "A001500":    // 6
                                iGearDepth = 290;
                                break;
                            case "A002000":    // 8
                                iGearDepth = 430;
                                break;
                            case "A002500":    // 10
                            case "A003000":    // 12
                                iGearDepth = 510;
                                break;
                            case "A003500":    // 14
                                iGearDepth = 418;
                                break;
                            case "A004000":    // 16
                                iGearDepth = 455;
                                break;
                            case "A004500":    // 18
                            case "A005000":    // 20
                            case "A005500":    // 22
                            case "A006000":    // 24
                                iGearDepth = 510;
                                break;
                            default:
                                break;
                        }
                        break;
                    case "900" :
                        switch (pdDto.getMain_size()) {
                            case "A001000":    // 4
                                iGearDepth = 290;
                                break;
                            case "A001500":    // 6
                                iGearDepth = 350;
                                break;
                            case "A002000":    // 8
                            case "A002500":    // 10
                                iGearDepth = 510;
                                break;
                            case "A003000":    // 12
                            case "A003500":    // 14
                            case "A004000":    // 16
                            case "A004500":    // 18
                            case "A005000":    // 20
                            case "A005500":    // 22
                            case "A006000":    // 24
                                iGearDepth = 620;
                                break;
                            default:
                                break;
                        }
                        break;
                    case "1500" :
                        switch (pdDto.getMain_size()) {
                            case "A001000":    // 4
                                iGearDepth = 350;
                                break;
                            case "A001500":    // 6
                            case "A002000":    // 8
                            case "A002500":    // 10
                            case "A003000":    // 12
                                iGearDepth = 510;
                                break;
                            case "A003500":    // 14
                            case "A004000":    // 16
                            case "A004500":    // 18
                            case "A005000":    // 20
                            case "A005500":    // 22
                            case "A006000":    // 24
                                iGearDepth = 620;
                                break;
                            default:
                                break;
                        }
                        break;
                    case "2500" :
                        switch (pdDto.getMain_size()) {
                            case "A001000":    // 4
                                iGearDepth = 620;
                                break;
                            case "A002000":    // 8
                                iGearDepth = 510;
                                break;
                            case "A002500":    // 10
                            case "A003000":    // 12
                            case "A003500":    // 14
                            case "A004000":    // 16
                            case "A004500":    // 18
                            case "A005000":    // 20
                            case "A005500":    // 22
                            case "A006000":    // 24
                                iGearDepth = 620;
                                break;
                            default:
                                break;
                        }
                        break;
                    default :
                        break;
                }
                resDto.setB(String.valueOf(0.5 * iGearDepth));
                break;
            case "CHECKVALVE" : // CheckValve
                if(pdDto.getMain_size().equals("*")
                        && pdDto.getPressure_rating().equals("*")) {
                    resDto.setFace_to_face(pdDto.getDim1());
                    resDto.setHeight_frm_val_cen(pdDto.getDim2());
                }
                break;
            case "CHECKVALVENIP" : // CheckValve_NIP
                if(pdDto.getMain_size().equals("*")
                        && pdDto.getPressure_rating().equals("*")) {
                    resDto.setFace_to_face(pdDto.getDim1());
                    resDto.setHeight_frm_val_cen(pdDto.getDim2());
                    resDto.setNipple_length(pdDto.getDim3());
                }
                break;
            case "DUALPLATECHECKVALVE" : // Dual Plate CheckValve
                if(pdDto.getMain_size().equals("*")
                        && pdDto.getPressure_rating().equals("*")) {
                    resDto.setFace_to_face(pdDto.getDim1());
                }
                break;
            case "BALLVALVELEVERNIP" : // BallValve_Lever_NIP
                if(pdDto.getPressure_rating().equals("*")) {
                    resDto.setNipple_length(pdDto.getDim5());
                }
            case "BALLVALVELEVER" : // BallValve_Lever
                if(pdDto.getPressure_rating().equals("*")) {
                    resDto.setFace_to_face(pdDto.getDim1());
                    iDim2 = this.fnToInt(pdDto.getDim2());
                    iDim4 = this.fnToInt(pdDto.getDim4());
                    resDto.setOffset_frm_val_cen(String.valueOf(iDim2 - iDim4));
                    resDto.setHeight(pdDto.getDim2());
                    resDto.setHandle_length(pdDto.getDim3());
                    iValCenLineToBot = 0;
                    iWidth = 0;
                    switch (pdDto.getMain_size()) {
                        case "A000150":    // 1/2
                            iValCenLineToBot = 18;
                            iWidth = 18;
                            break;
                        case "A000200":    // 3/4
                            iValCenLineToBot = 21;
                            iWidth = 18;
                            break;
                        case "A000250":    // 1
                            iValCenLineToBot = 27;
                            iWidth = 22;
                            break;
                        case "A000400":    // 1-1/2
                            iValCenLineToBot = 31;
                            iWidth = 25;
                            break;
                        case "A000500":    // 2
                            iValCenLineToBot = 39;
                            iWidth = 30;
                            break;
                        case "A000800":    // 3
                            iValCenLineToBot = 52;
                            iWidth = 42;
                            break;
                        case "A001000":    // 4
                            iValCenLineToBot = 72;
                            iWidth = 50;
                            break;
                        case "A001500":    // 6
                            iValCenLineToBot = 109;
                            iWidth = 60;
                            break;
                        case "A002000":    // 8
                            iValCenLineToBot = 145;
                            iWidth = 60;
                            break;
                        case "A002500":    // 10
                            iValCenLineToBot = 177;
                            iWidth = 80;
                            break;
                        case "A003000":    // 12
                            iValCenLineToBot = 198;
                            iWidth = 100;
                            break;
                        case "A003500":    // 14
                            iValCenLineToBot = 231;
                            iWidth = 100;
                            break;
                        case "A004000":    // 16
                            iValCenLineToBot = 264;
                            iWidth = 120;
                            break;
                        case "A004500":    // 18
                            iValCenLineToBot = 297;
                            iWidth = 140;
                            break;
                        case "A005000":    // 20
                            iValCenLineToBot = 330;
                            iWidth = 150;
                            break;
                        case "A005500":    // 22
                            iValCenLineToBot = 363;
                            iWidth = 150;
                            break;
                        case "A006000":    // 24
                            iValCenLineToBot = 396;
                            iWidth = 150;
                            break;
                        default:
                            break;
                    }
                    resDto.setVal_cen_line_to_bot(String.valueOf(iValCenLineToBot));
                    resDto.setWidth(String.valueOf(iWidth));
                }
                break;
            case "BALLVALVEGEAR" : // BallValve_Gear
                if(pdDto.getPressure_rating().equals("*")) {
                    iDim3 = this.fnToInt(pdDto.getDim3());
                    iDim5 = this.fnToInt(pdDto.getDim5());
                    iGearDepth = 2 * (iDim3 - iDim5);
                    iHwYOffsetFrmGearBot = iDim3 - iDim5;
                    resDto.setFace_to_face(pdDto.getDim1());
                    resDto.setOffset_frm_val_cen(pdDto.getDim3());
                    resDto.setVal_cen_line_to_bot(pdDto.getDim2());
                    resDto.setHw_diameter(pdDto.getDim7());
                    resDto.setGear_depth(String.valueOf(iGearDepth));
                    resDto.setHw_z_offset_op_frm_stem(pdDto.getDim4());
                    resDto.setHw_y_offset_gear_bot(String.valueOf(iHwYOffsetFrmGearBot));
                    resDto.setOffset(pdDto.getDim6());
                    switch (pdDto.getMain_size()) {
                        case "A000400":    // 1-1/2
                            iWidth = 25;
                            break;
                        case "A000500":    // 2
                            iWidth = 30;
                            break;
                        case "A000800":    // 3
                            iWidth = 42;
                            break;
                        case "A001000":    // 4
                            iWidth = 50;
                            break;
                        case "A001500":    // 6
                        case "A002000":    // 8
                            iWidth = 60;
                            break;
                        case "A002500":    // 10
                            iWidth = 80;
                            break;
                        case "A003000":    // 12
                        case "A003500":    // 14
                            iWidth = 100;
                            break;
                        case "A004000":    // 16
                            iWidth = 120;
                            break;
                        case "A004500":    // 18
                            iWidth = 140;
                            break;
                        case "A005000":    // 20
                        case "A005500":    // 22
                        case "A006000":    // 24
                        case "A006500":    // 26
                        case "A007000":    // 28
                            iWidth = 150;
                            break;
                        case "A007500":    // 30
                        case "A008000":    // 32
                            iWidth = 180;
                            break;
                        case "A008500":    // 34
                        case "A009000":    // 36
                        case "A009500":    // 38
                            iWidth = 200;
                            break;
                        case "A010000":    // 40
                        case "A010500":    // 42
                        case "A011000":    // 44
                        case "A011500":    // 46
                        case "A012000":    // 48
                            iWidth = 220;
                            break;
                        case "A012500":    // 50
                            iWidth = 240;
                            break;
                    }
                    resDto.setWidth(String.valueOf(iWidth));
                }
                break;
            case "BUTTERFLYVALVELEVER" : // ButterflyValve_Lever
                if(pdDto.getPressure_rating().equals("*")) {
                    iDim3 = this.fnToInt(pdDto.getDim3());
                    iDim5 = this.fnToInt(pdDto.getDim5());

                    resDto.setFace_to_face(pdDto.getDim1());
                    resDto.setVal_cen_line_to_bot(pdDto.getDim2());
                    resDto.setWidth("10");

                    iLeverHeight = 0;
                    iBaseRadius = 0;
                    switch (pdDto.getMain_size()) {
                        case "A000150":    // 1/2
                        case "A000200":    // 3/4
                        case "A000250":    // 1
                        case "A000400":    // 1-1/2
                        case "A000500":    // 2
                            iLeverHeight = 40;
                            iBaseRadius = 30;
                            break;
                        case "A000800":    // 3
                            iLeverHeight = 50;
                            iBaseRadius = 30;
                            break;
                        case "A001000":    // 4
                            iLeverHeight = 50;
                            iBaseRadius = 40;
                            break;
                        case "A001500":    // 6
                        case "A002000":    // 8
                            iLeverHeight = 50;
                            iBaseRadius = 60;
                            break;
                        case "A002500":    // 10
                            iLeverHeight = 50;
                            iBaseRadius = 80;
                            break;
                        case "A003000":    // 12
                            iLeverHeight = 60;
                            iBaseRadius = 80;
                            break;
                        case "A003500":    // 14
                        case "A004000":    // 16
                        case "A004500":    // 18
                            iLeverHeight = 60;
                            iBaseRadius = 100;
                            break;
                        case "A005000":    // 20
                        case "A005500":    // 22
                        case "A006000":    // 24
                            iLeverHeight = 80;
                            iBaseRadius = 120;
                            break;
                        case "*":    // *
                            resDto.setHw_diameter(pdDto.getDim7());
                            break;
                        default:
                            break;
                    }

                    iOffsetFrmValCen = iDim3 - iLeverHeight;
                    resDto.setLever_length(pdDto.getDim4());
                    resDto.setLever_height(String.valueOf(iLeverHeight));
                    resDto.setBase_radius(String.valueOf(iBaseRadius));

                    resDto.setOffset_frm_val_cen(String.valueOf(iOffsetFrmValCen));
                }
                break;
            case "BUTTERFLYVALVEGEAR" : // ButterflyValve_Gear
                if(pdDto.getMain_size().equals("*")
                        && pdDto.getPressure_rating().equals("*")) {
                    iDim3 = this.fnToInt(pdDto.getDim3());
                    iDim5 = this.fnToInt(pdDto.getDim5());
                    iOffsetFrmValCen = iDim3 - ( 2* (iDim3 - iDim5));
                    iGearDepth = 2 * (iDim3 - iDim5);
                    iHwYOffsetFrmGearBot = iDim3 - iDim5;
                    resDto.setFace_to_face(pdDto.getDim1());
                    resDto.setOffset_frm_val_cen(String.valueOf(iOffsetFrmValCen));
                    resDto.setVal_cen_line_to_bot(pdDto.getDim2());
                    resDto.setWidth("10");
                    resDto.setGear_depth(String.valueOf(iGearDepth));
                    resDto.setHw_z_offset_op_frm_stem(pdDto.getDim8());
                    resDto.setHw_x_offset_frm_op_stem(pdDto.getDim4());
                    resDto.setHw_y_offset_gear_bot(String.valueOf(iHwYOffsetFrmGearBot));
                    resDto.setOffset(pdDto.getDim6());
                }
                break;
            default :
                break;

        }

        return resDto;
    }


    //신규로직
    private PipingValveDimmConvDto getMatchedPipingValveConvTableRow(PdTableDto pdDto){
        List<PipingValveDimmConvDto> valveDimConvTableList = new ArrayList<>();
        /* table => json 변환 사이트 이용할 것 / 그 후 "-" => ""로만 변환 */
        ClassPathResource resource = new ClassPathResource("json/valve_dimension_conversion_table.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //todo check resource 폴더의 json을 사용할 지 table을 사용할 지 확인
        try (InputStream inputStream = resource.getInputStream()) {
            valveDimConvTableList = objectMapper.readValue(inputStream, new TypeReference<List<PipingValveDimmConvDto>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(Objects.isNull(valveDimConvTableList) || valveDimConvTableList.size() == 0){
            return null;
        }

        String keyGubun = "_";
        Map<String, PipingValveDimmConvDto> valveDimConvTableKeyMap = valveDimConvTableList.stream().filter(
                x-> Objects.nonNull(x.getCata_type()) && Objects.nonNull(x.getSize()) && Objects.nonNull(x.getRating())
        ).collect(Collectors.toMap(a-> a.getCata_type()+keyGubun+a.getSize()+keyGubun+a.getRating(), Function.identity()));

        String pdTableKey = pdDto.getCata_type() + keyGubun + pdDto.getMain_size() + keyGubun + pdDto.getPressure_rating();

        PipingValveDimmConvDto matchedConvTableDto = valveDimConvTableKeyMap.get(pdTableKey);

        if(Objects.isNull(matchedConvTableDto)){
            return null;
        }

        return matchedConvTableDto;
    }

    private void convertPdToPipingValve(PipingValveDimmConvDto matchedConvTableDto, PdTableDto pdDto) {
        String className = matchedConvTableDto.getClass().getName();
        Class targetClass;
        Method methods[];
        try {
            // class가 존재하지 않을 경우 ClassNotFoundException 발생
            targetClass = Class.forName(className);

            // targetClass에 선언된 모든 메소드 가져오기
            methods = targetClass.getDeclaredMethods();

        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        for(int i = 0; i<methods.length; i++) {
            Method method = methods[i];
            String methodName = method.getName();

            // 모든 setter 메소드
            if(methodName.startsWith("set")) {
                String getMethodName = methodName.replaceFirst("set", "get");
                try {
                    // 해당 필드의 getterMethod 가져오기(ex - getInsertChk())
                    Method getterMethod = targetClass.getMethod(getMethodName);
                    getterMethod.setAccessible(true);
                    String getVal = String.valueOf(getterMethod.invoke(matchedConvTableDto));
                    // set으로 데이터 넣기
                    if(StringUtils.isNotEmpty(getVal)) {
                        methods[i].invoke(matchedConvTableDto, calculateColumn(pdDto, matchedConvTableDto, getVal));
                    }
                } catch(Exception e) {
                    continue;
                }
            }
        }
    }

    private String calculateColumn(PdTableDto pdDto, PipingValveDimmConvDto matchedConvTableDto, String calString) {
        if(StringUtils.isEmpty(calString)){
            return calString;
        }
        switch (calString) {
            case "DIM1"                   : return pdDto.getDim1();
            case "DIM2"                   : return pdDto.getDim2();
            case "DIM3"                   : return pdDto.getDim3();
            case "DIM4"                   : return pdDto.getDim4();
            case "DIM5"                   : return pdDto.getDim5();
            case "DIM6"                   : return pdDto.getDim6();
            case "DIM7"                   : return pdDto.getDim7();
            case "DIM8"                   : return pdDto.getDim8();
            case "DIM2 - (21/0.6)"        : return (Float.valueOf(pdDto.getDim2())-21/0.6)+"";
            case "DIM2 - (33/0.6)"        : return (Float.valueOf(pdDto.getDim2())-33/0.6)+"";
            case "DIM2 - (48/0.6)"        : return (Float.valueOf(pdDto.getDim2())-48/0.6)+"";
            case "DIM2 - (60/0.6)"        : return (Float.valueOf(pdDto.getDim2())-60/0.6)+"";
            case "DIM2 - (86/0.6)"        : return (Float.valueOf(pdDto.getDim2())-86/0.6)+"";
            case "DIM2 - (113/0.6)"       : return (Float.valueOf(pdDto.getDim2())-113/0.6)+"";
            case "DIM2 - (166/0.6)"       : return (Float.valueOf(pdDto.getDim2())-166/0.6)+"";
            case "DIM2 - (218/0.6)"       : return (Float.valueOf(pdDto.getDim2())-218/0.6)+"";
            case "DIM2 - (273/0.6)"       : return (Float.valueOf(pdDto.getDim2())-273/0.6)+"";
            case "DIM2 - (300/0.6)"       : return (Float.valueOf(pdDto.getDim2())-300/0.6)+"";
            case "DIM2 - (348/0.6)"       : return (Float.valueOf(pdDto.getDim2())-348/0.6)+"";
            case "DIM3 - \"GearDepth\"/2" : return (Float.valueOf(pdDto.getDim3())-Float.valueOf(matchedConvTableDto.getGear_depth())/2.0)+"";
            case "DIM2 - 35"              : return (Float.valueOf(pdDto.getDim2())-35)+"";
            case "DIM2 - 40"              : return (Float.valueOf(pdDto.getDim2())-40)+"";
            case "DIM2 - 45"              : return (Float.valueOf(pdDto.getDim2())-45)+"";
            case "DIM2 - 50"              : return (Float.valueOf(pdDto.getDim2())-50)+"";
            case "DIM2 - 58"              : return (Float.valueOf(pdDto.getDim2())-58)+"";
            case "DIM2 - 70"              : return (Float.valueOf(pdDto.getDim2())-70)+"";
            case "DIM2 - 80"              : return (Float.valueOf(pdDto.getDim2())-80)+"";
            case "DIM2 - 90"              : return (Float.valueOf(pdDto.getDim2())-90)+"";
            case "DIM2 - 105"             : return (Float.valueOf(pdDto.getDim2())-105)+"";
            case "DIM2 - 110"             : return (Float.valueOf(pdDto.getDim2())-110)+"";
            case "DIM2 - 120"             : return (Float.valueOf(pdDto.getDim2())-120)+"";
            case "0.44 * DIM2"            : return (Float.valueOf(pdDto.getDim2())*0.44)+"";
            case "DIM2 - DIM4"            : return (Float.valueOf(pdDto.getDim2())-Float.valueOf(pdDto.getDim4()))+"";
            case "DIM3 - \"LeverHeight\"" : return (Float.valueOf(pdDto.getDim3())-Float.valueOf(matchedConvTableDto.getLever_height()))+"";
            case "DIM3-2*(DIM3-DIM5)"     : return (Float.valueOf(pdDto.getDim3())-2.0*(Float.valueOf(Float.valueOf(pdDto.getDim3())-Float.valueOf(pdDto.getDim5()))))+"";
            case "2 * (DIM3-DIM5)"        : return (2.0*(Float.valueOf(Float.valueOf(pdDto.getDim3())-Float.valueOf(pdDto.getDim5()))))+"";
            case "2 * (DIM2-DIM3)"        : return (2.0*(Float.valueOf(Float.valueOf(pdDto.getDim2())-Float.valueOf(pdDto.getDim3()))))+"";
            case "0.5 * \"GearDiameter\"" : return (0.5*Float.valueOf(matchedConvTableDto.getGear_diameter()))+"";
            case "DIM3-DIM5"              : return (Float.valueOf(Float.valueOf(pdDto.getDim3())-Float.valueOf(pdDto.getDim5())))+"";
            default                       : return calString;
        }
    }








}
