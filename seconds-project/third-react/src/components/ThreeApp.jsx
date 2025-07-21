
import React, { useState } from 'react'

const ThreeApp = () => {


  const [photo,setPhoto]=useState('../image2/b2.png');

  //이미지변경
  const changePhoto=(e)=>{
    setPhoto(e.target.value);
  }

  return (
    <div>
        
        <h1 className='alert alert-danger'>ThreeApp</h1> 
        
        <div>
            <b>이모티콘선택: </b>
            <label><input type="radio" name='photo' value='../image2/b2.png' onClick={changePhoto} defaultChecked/>이미지1</label>&nbsp;&nbsp;
            <label><input type="radio" name='photo' value='../image2/b3.png' onClick={changePhoto} />이미지2</label>&nbsp;&nbsp;
            <label><input type="radio" name='photo' value='../image2/b4.png' onClick={changePhoto}/>이미지3</label>&nbsp;&nbsp;
            <label><input type="radio" name='photo' value='../image2/b5.png' onClick={changePhoto}/>이미지4</label>&nbsp;&nbsp;
            <label><input type="radio" name='photo' value='../image2/b6.png' onClick={changePhoto}/>이미지5</label>&nbsp;&nbsp;
            <label><input type="radio" name='photo' value='../image2/b7.png' onClick={changePhoto}/>이미지6</label>&nbsp;&nbsp;
        </div>

        <img src={photo} alt="" />
    </div>
  )
}

export default ThreeApp