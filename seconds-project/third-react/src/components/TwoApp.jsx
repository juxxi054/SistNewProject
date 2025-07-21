import React, { useState } from 'react'
//이미지4개 
import img1 from '../assets/image/Food/1.jpg'
import img2 from '../assets/image/Food/2.jpg'
import img3 from '../assets/image/Food/10.jpg'
import img4 from '../assets/image/Food/11.jpg'

const TwoApp = () => {

    // 전화1,2,3 
    const [hp1,setHp1]=useState('02');
    const [hp2,setHp2]=useState('1111');
    const [hp3,setHp3]=useState('2222');
    const [photo,setPhoto]=useState(1);

    //이미지변경이벤트
    const changePhoto=(e)=>{
        setPhoto(Number(e.target.value));
    }

    const changeHp1=(e)=>{
        setHp1(e.target.value);
    }
    const changeHp2=(e)=>{
        setHp2(e.target.value);
    }
    const changeHp3=(e)=>{
        setHp3(e.target.value);
    }

  return (
    <div>
        
       <h1 className='alert alert-danger'>TwoApp</h1> 
        <br/><br/>
        <div className='input-group' >
            <select className='form-control' style={{width:'100px'}}
            onChange={changeHp1}>
               <option>02</option>
               <option>010</option>
               <option>031</option>
               <option>017</option>
            </select>
            <b>-</b>
            <input type="text" maxLength='4' className='form-control'
            style={{width:'100px'}} onKeyUp={changeHp2}/>
            <b>-</b>
            <input type="text" maxLength='4' className='form-control'
            style={{width:'100px'}} onKeyUp={changeHp3}/>

            <br/><br/>
            
        </div>
        <div className='input-img'>
               <b>이미지선택: </b>
            <select className='form-control' onChange={changePhoto}>
                <option value="1">아보카도샌드위치</option>
                <option value="2">소고기꼬치</option>
                <option value="10">에그덮밥</option>
                <option value="11">망고빙수</option>
            </select>
        </div>

        <div className='output'>
            <h1>{hp1}-{hp2}-{hp3}</h1>
        </div>
        <div className='putput_image'>
          {/* src의 이미지를 출력해보세요 */}
          <img src={photo===1?img1:photo===2?img2:photo===3?img3:img4} alt=""
          className='photo' />
        </div>
    </div>
  )
}

export default TwoApp