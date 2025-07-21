
import React from 'react'
import img1 from '../assets/image/j/01.png'
import img2 from '../assets/image/j/02.png'
import img3 from '../assets/image/j/03.png'
import img4 from '../assets/image/j/04.png'
import img5 from '../assets/image/j/05.png'

const FourApp = () => {

    //배열변수선언
    const names=['강호동','이영자','유재석','차은우','카리나'];

    const nameList=names.map((name)=>(<li>{name}</li>));

    //색상을 배열로
    const colors=['yellow','tomato','gray','pink','green'];

    //이미지를 배열변수에 넣기_src
    const imgArr=[img1,img2,img3,img4,img5];

    //이미지배열변수_public
    const imgPArr=['6','5','3','7','2'];



  return (
    <div>
        
        <h1 className='alert alert-danger'>FourApp_반복문 연습</h1> 
        <ol>{nameList}</ol>
        <hr/>
        <ul>
          {
            //반복문을 리턴에 직접주어도 된다
            names.map((name,index)=>(<b style={{marginLeft:'10px'}}>{index}:{name}</b>))
          }
        </ul>
        <hr/>

        {/* colors를 div 로 출력할것(box) */}
        {
          colors.map((color)=>(<div className='box' style={{backgroundColor:color}}></div>))

        }
        <br/><br/>
        <hr style={{clear:'both'}}/>

         {/* src의 이미지를 배열반복출력하기 너비 100 */}

        {
          imgArr.map((myimg)=>(<img src={myimg}  style={{width:'100px'}} />))

        }

        <hr/>

       {/* public 의 이미지 배열반복출력   css */}
        {

          imgPArr.map((photo)=>(<img src={'../image2/b'+photo+'.png'} className='myphoto'/>))
        }
        <hr/>
        {
          imgPArr.map((photo)=>(<img src={`../image2/b${photo}.png`} className='myphoto'/>))
        }

        </div>
  )
}

export default FourApp