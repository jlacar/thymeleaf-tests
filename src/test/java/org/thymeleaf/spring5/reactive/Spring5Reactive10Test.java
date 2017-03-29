/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2016, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.spring5.reactive;

import java.util.List;

import org.junit.Test;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.reactive.data.Album;
import org.thymeleaf.spring5.reactive.data.AlbumRepository;
import reactor.core.publisher.Flux;

public final class Spring5Reactive10Test extends AbstractSpring5ReactiveTest {



    @Test
    public void testDataDrivenEmpty01() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums).take(0), 1));

        testTemplate("reactive10", null, ctx1, "reactive10-01");

    }


    @Test
    public void testDataDrivenEmpty02() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();

        testTemplate("reactive10", null, ctx1, "reactive10-01");

    }


    @Test
    public void testDataDrivenLarge01() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums), 1));

        testTemplate("reactive10", null, ctx1, "reactive10-02");

    }


    @Test
    public void testDataDrivenLarge02() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums), 2));

        testTemplate("reactive10", null, ctx1, "reactive10-02");

    }


    @Test
    public void testDataDrivenLarge03() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums), 3));

        testTemplate("reactive10", null, ctx1, "reactive10-02");

    }


    @Test
    public void testDataDrivenLarge04() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums), 7));

        testTemplate("reactive10", null, ctx1, "reactive10-02");

    }


    @Test
    public void testDataDrivenLarge05() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums), 11));

        testTemplate("reactive10", null, ctx1, "reactive10-02");

    }


    @Test
    public void testDataDrivenLarge06() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums), 137));

        testTemplate("reactive10", null, ctx1, "reactive10-02");

    }


    @Test
    public void testDataDrivenLarge07() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums), 1024));

        testTemplate("reactive10", null, ctx1, "reactive10-02");

    }


    @Test
    public void testDataDrivenLarge08() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums), Integer.MAX_VALUE));

        testTemplate("reactive10", null, ctx1, "reactive10-02");

    }


    @Test
    public void testDataDrivenOne01() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums).take(1), 1));

        testTemplate("reactive10", null, ctx1, "reactive10-03");

    }


    @Test
    public void testDataDrivenOne02() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums).take(1), 2));

        testTemplate("reactive10", null, ctx1, "reactive10-03");

    }


    @Test
    public void testDataDrivenOne03() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums).take(1), 3));

        testTemplate("reactive10", null, ctx1, "reactive10-03");

    }


    @Test
    public void testDataDrivenOne04() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums).take(1), 7));

        testTemplate("reactive10", null, ctx1, "reactive10-03");

    }


    @Test
    public void testDataDrivenOne05() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums).take(1), 11));

        testTemplate("reactive10", null, ctx1, "reactive10-03");

    }


    @Test
    public void testDataDrivenOne06() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums).take(1), 137));

        testTemplate("reactive10", null, ctx1, "reactive10-03");

    }


    @Test
    public void testDataDrivenOne07() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums).take(1), 1024));

        testTemplate("reactive10", null, ctx1, "reactive10-03");

    }


    @Test
    public void testDataDrivenOne08() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums).take(1), Integer.MAX_VALUE));

        testTemplate("reactive10", null, ctx1, "reactive10-03");

    }


    @Test
    public void testDataDrivenTwo01() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums).take(2), 1));

        testTemplate("reactive10", null, ctx1, "reactive10-04");

    }


    @Test
    public void testDataDrivenTwo02() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums).take(2), 2));

        testTemplate("reactive10", null, ctx1, "reactive10-04");

    }


    @Test
    public void testDataDrivenTwo03() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums).take(2), 3));

        testTemplate("reactive10", null, ctx1, "reactive10-04");

    }


    @Test
    public void testDataDrivenTwo04() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums).take(2), 7));

        testTemplate("reactive10", null, ctx1, "reactive10-04");

    }


    @Test
    public void testDataDrivenTwo05() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums).take(2), 11));

        testTemplate("reactive10", null, ctx1, "reactive10-04");

    }


    @Test
    public void testDataDrivenTwo06() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums).take(2), 137));

        testTemplate("reactive10", null, ctx1, "reactive10-04");

    }


    @Test
    public void testDataDrivenTwo07() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums).take(2), 1024));

        testTemplate("reactive10", null, ctx1, "reactive10-04");

    }


    @Test
    public void testDataDrivenTwo08() throws Exception {

        final List<Album> albums = AlbumRepository.findAllAlbums();

        final Context ctx1 = new Context();
        ctx1.setVariable("albums", new ReactiveDataDriverContextVariable(Flux.fromIterable(albums).take(2), Integer.MAX_VALUE));

        testTemplate("reactive10", null, ctx1, "reactive10-04");

    }



}
