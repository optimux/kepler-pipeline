/*
 * Copyright 2017 United States Government as represented by the
 * Administrator of the National Aeronautics and Space Administration.
 * All Rights Reserved.
 * 
 * This file is available under the terms of the NASA Open Source Agreement
 * (NOSA). You should have received a copy of this agreement with the
 * Kepler source code; see the file NASA-OPEN-SOURCE-AGREEMENT.doc.
 * 
 * No Warranty: THE SUBJECT SOFTWARE IS PROVIDED "AS IS" WITHOUT ANY
 * WARRANTY OF ANY KIND, EITHER EXPRESSED, IMPLIED, OR STATUTORY,
 * INCLUDING, BUT NOT LIMITED TO, ANY WARRANTY THAT THE SUBJECT SOFTWARE
 * WILL CONFORM TO SPECIFICATIONS, ANY IMPLIED WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR FREEDOM FROM
 * INFRINGEMENT, ANY WARRANTY THAT THE SUBJECT SOFTWARE WILL BE ERROR
 * FREE, OR ANY WARRANTY THAT DOCUMENTATION, IF PROVIDED, WILL CONFORM
 * TO THE SUBJECT SOFTWARE. THIS AGREEMENT DOES NOT, IN ANY MANNER,
 * CONSTITUTE AN ENDORSEMENT BY GOVERNMENT AGENCY OR ANY PRIOR RECIPIENT
 * OF ANY RESULTS, RESULTING DESIGNS, HARDWARE, SOFTWARE PRODUCTS OR ANY
 * OTHER APPLICATIONS RESULTING FROM USE OF THE SUBJECT SOFTWARE.
 * FURTHER, GOVERNMENT AGENCY DISCLAIMS ALL WARRANTIES AND LIABILITIES
 * REGARDING THIRD-PARTY SOFTWARE, IF PRESENT IN THE ORIGINAL SOFTWARE,
 * AND DISTRIBUTES IT "AS IS."
 * 
 * Waiver and Indemnity: RECIPIENT AGREES TO WAIVE ANY AND ALL CLAIMS
 * AGAINST THE UNITED STATES GOVERNMENT, ITS CONTRACTORS AND
 * SUBCONTRACTORS, AS WELL AS ANY PRIOR RECIPIENT. IF RECIPIENT'S USE OF
 * THE SUBJECT SOFTWARE RESULTS IN ANY LIABILITIES, DEMANDS, DAMAGES,
 * EXPENSES OR LOSSES ARISING FROM SUCH USE, INCLUDING ANY DAMAGES FROM
 * PRODUCTS BASED ON, OR RESULTING FROM, RECIPIENT'S USE OF THE SUBJECT
 * SOFTWARE, RECIPIENT SHALL INDEMNIFY AND HOLD HARMLESS THE UNITED
 * STATES GOVERNMENT, ITS CONTRACTORS AND SUBCONTRACTORS, AS WELL AS ANY
 * PRIOR RECIPIENT, TO THE EXTENT PERMITTED BY LAW. RECIPIENT'S SOLE
 * REMEDY FOR ANY SUCH MATTER SHALL BE THE IMMEDIATE, UNILATERAL
 * TERMINATION OF THIS AGREEMENT.
 */

package gov.nasa.kepler.systest.sbt.data;

import gov.nasa.spiffy.common.SimpleIntTimeSeries;

/**
 * This class wraps {@link SimpleIntTimeSeries} with a type.
 * 
 * @author Miles Cote
 * 
 */
public class SbtSimpleIntTimeSeries implements SbtDataContainer {

    private String type = "";

    private SimpleIntTimeSeries timeSeries = new SimpleIntTimeSeries();

    @Override
    public String toMissingDataString(ToMissingDataStringParameters parameters) {
        SbtGapIndicators gapIndicators = new SbtGapIndicators(
            timeSeries.getGapIndicators());
        SbtList values = new SbtList(
            SbtDataContainerListFactory.getInstance(timeSeries.getValues()),
            gapIndicators);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SbtDataUtils.toString("type",
            new SbtString(type).toMissingDataString(parameters)));
        stringBuilder.append(SbtDataUtils.toString("gapIndicators",
            gapIndicators.toMissingDataString(parameters)));
        stringBuilder.append(SbtDataUtils.toString("values",
            values.toMissingDataString(parameters)));

        return stringBuilder.toString();
    }

    public SbtSimpleIntTimeSeries() {
    }

    public SbtSimpleIntTimeSeries(SimpleIntTimeSeries timeSeries) {
        type = SbtDataUtils.EMPTY;
        this.timeSeries = timeSeries;
    }

    public SbtSimpleIntTimeSeries(String type, SimpleIntTimeSeries timeSeries) {
        this.type = type;
        this.timeSeries = timeSeries;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SimpleIntTimeSeries getTimeSeries() {
        return timeSeries;
    }

    public void setTimeSeries(SimpleIntTimeSeries timeSeries) {
        this.timeSeries = timeSeries;
    }

}