uniform mat4 uProjMatrix;
uniform mat4 uViewMatrix;
uniform mat4 uModelMatrix;
uniform mat4 uRotateMatrix;

attribute vec3 aPosition;
attribute vec2 aCoordinate;

varying vec2 vCoordinate;

void main(){
    //MVP矩阵（Model-View-Projection 模型-视图-投影矩阵）
    gl_Position=uProjMatrix*uRotateMatrix*uViewMatrix*uModelMatrix*vec4(aPosition,1);
    vCoordinate=aCoordinate;
}