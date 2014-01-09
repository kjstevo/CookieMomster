/*
 * ******************************************************************************
 *   Copyright (c) 2013 Gabriele Mariotti.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *  *****************************************************************************
 */


package net.kjmaster.cookiemom.summary.stat.scout;

/**
 * @author Gabriele Mariotti (gabri.mariotti@gmail.com)
 */
class SummaryStatScoutValues {
    String code;
    float value;
    float delta;
    float deltaPerc;

    public SummaryStatScoutValues() {
    }

    public SummaryStatScoutValues(String code, float value, float delta, float deltaPerc) {
        this.code = code;
        this.value = value;
        this.delta = delta;
        this.deltaPerc = deltaPerc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getDelta() {
        return delta;
    }

    public void setDelta(float delta) {
        this.delta = delta;
    }

    public float getDeltaPerc() {
        return deltaPerc;
    }

    public void setDeltaPerc(float deltaPerc) {
        this.deltaPerc = deltaPerc;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com